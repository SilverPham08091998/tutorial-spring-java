package com.example.springjava.security;

import com.example.springjava.entity.AuthenciationEntity;
import com.example.springjava.entity.JWTExpireEntity;
import com.example.springjava.entity.JwtHistoryEntity;
import com.example.springjava.payload.response.AuthResponse;
import com.example.springjava.respository.AuthenciationRepository;
import com.example.springjava.respository.JwtExpireRepository;
import com.example.springjava.respository.JwtHistoryRepository;
import com.example.springjava.security.model.UserPrincipal;
import io.jsonwebtoken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LogManager.getLogger(JwtTokenProvider.class);
    private final String JWT_SECRET = "jwt_secret_key";
    private final long JWT_EXPIRATION = 3000000; // 7 days in milliseconds
    private final long JWT_REFRESH_EXPIRATION = 604800000; // 7 days in milliseconds

    @Autowired
    JwtHistoryRepository jwtHistoryRepository;

    @Autowired
    JwtExpireRepository jwtExpireRepository;

    @Autowired
    AuthenciationRepository authenciationRepository;


    public String generateAccessToken(String jti, UserPrincipal userPrincipal, Date now, Date expiryDate) {
        Claims claims = Jwts.claims().setSubject(userPrincipal.getUsername());
        claims.put("userId", userPrincipal.getUserId());
        claims.put("email", userPrincipal.getEmail());
        claims.put("role", userPrincipal.getRole());
        claims.put("phoneNumber", userPrincipal.getPhoneNumber());
        claims.put("authorities", userPrincipal.getAuthorities());
        claims.put("deviceId", userPrincipal.getDeviceId());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .setId(jti)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String generateRefreshToken(String jti, String ati, UserPrincipal userPrincipal, Date now, Date expiryDate) {
        Claims claims = Jwts.claims().setSubject(userPrincipal.getUsername());
        claims.put("authorities", userPrincipal.getAuthorities());
        claims.put("ati", ati);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .setId(jti)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUserNameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public Claims decodeJwt(String token) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String authToken) {
        try {
            Claims body = decodeJwt(authToken);
            String username = body.getSubject();
            String deviceId = body.get("deviceId").toString();
            AuthenciationEntity authenciationEntity = authenciationRepository.findAuthenciationEntityByUsernameAndAndDeviceId(username, deviceId);
            if (authenciationEntity == null) {
                return false;
            }
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
            String username = getUserNameFromToken(authToken);
            List<JwtHistoryEntity> listJWT = jwtHistoryRepository.findJwtHistoryEntitiesByUsername(username);
            for (JwtHistoryEntity jwtHistory : listJWT) {
                jwtHistoryRepository.delete(jwtHistory);
                JWTExpireEntity jwtExpire = new JWTExpireEntity();
                jwtExpire.setJti(jwtHistory.getJti());
                jwtExpire.setAti(jwtHistory.getAti());
                jwtExpire.setTypeToken(jwtHistory.getTypeToken());
                jwtExpire.setUserId(jwtHistory.getUserId());
                jwtExpire.setDeviceId(jwtHistory.getDeviceId());
                jwtExpire.setExpireDate(jwtExpire.getExpireDate());
                jwtExpire.setExpireStatus("EXPIRE");
                jwtExpire.setUsername(username);
                jwtExpireRepository.save(jwtExpire);
            }
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

    public AuthResponse createAuthResponse(Authentication authentication) {
        Map<String, String> token = createAccessToken(authentication);
        Map<String, String> refreshToken = createRefreshToken(authentication, token.get("jti"));
        return new AuthResponse(token.get("token"), refreshToken.get("token"), token.get("jti"));
    }

    private Map<String, String> createAccessToken(Authentication authentication) {
        String jti = UUID.randomUUID().toString();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        HashMap<String, String> result = new HashMap<>();
        result.put("jti", jti);
        result.put("token", this.generateAccessToken(jti, userPrincipal, now, expiryDate));
        insertJWTToDB(jti, userPrincipal, null, "ACCESS_TOKEN", expiryDate);
        return result;
    }

    private Map<String, String> createRefreshToken(Authentication authentication, String ati) {
        String jti = UUID.randomUUID().toString();
        HashMap<String, String> result = new HashMap<>();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_REFRESH_EXPIRATION);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        result.put("jti", jti);
        result.put("token", this.generateRefreshToken(ati, jti, userPrincipal, now, expiryDate));
        insertJWTToDB(jti, userPrincipal, ati, "REFRESH_TOKEN", expiryDate);
        return result;
    }

    private void insertJWTToDB(String jti, UserPrincipal user, String ati, String typeToken, Date expireDate) {
        JwtHistoryEntity jwtHistory = jwtHistoryRepository.findJwtHistoryEntityByUsernameAndTypeToken(user.getUsername(), typeToken);
        if (jwtHistory != null) {
            jwtHistoryRepository.delete(jwtHistory);
            JWTExpireEntity jwtExpire = new JWTExpireEntity();
            jwtExpire.setJti(jwtHistory.getJti());
            jwtExpire.setExpireDate(jwtHistory.getExpireDate());
            jwtExpire.setAti(jwtHistory.getAti());
            jwtExpire.setTypeToken(jwtHistory.getTypeToken());
            jwtExpire.setUserId(jwtHistory.getUserId());
            jwtExpire.setExpireStatus("SIGN_IN_ANOTHER_DEVICE");
            jwtExpire.setUsername(jwtHistory.getUsername());
            jwtExpire.setDeviceId(jwtHistory.getDeviceId());
            jwtExpireRepository.save(jwtExpire);
        }
        JwtHistoryEntity entity = new JwtHistoryEntity();
        entity.setJti(jti);
        entity.setAti(ati);
        entity.setTypeToken(typeToken);
        entity.setUserId(user.getUserId());
        entity.setEmail(user.getEmail());
        entity.setPhoneNumber(user.getPhoneNumber());
        entity.setExpireDate(expireDate);
        entity.setJwtActive(true);
        entity.setDeviceId(user.getDeviceId());
        entity.setCreatedDate(new Date());
        entity.setUsername(user.getUsername());
        jwtHistoryRepository.save(entity);
    }
}

