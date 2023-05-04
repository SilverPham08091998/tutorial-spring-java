package com.example.springjava.security;

import com.example.springjava.payload.response.AuthResponse;
import com.example.springjava.security.model.UserPrincipal;
import io.jsonwebtoken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtTokenProvider {
    private static final Logger logger = LogManager.getLogger(JwtTokenProvider.class);
    private final String JWT_SECRET = "jwt_secret_key";
    private final long JWT_EXPIRATION = 604800000L; // 7 days in milliseconds

    public String generateAccessToken(Authentication authentication, String jti) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        Claims claims = Jwts.claims().setSubject(userPrincipal.getUsername());
        claims.put("userId", userPrincipal.getUserId());
        claims.put("email", userPrincipal.getEmail());
        claims.put("role", userPrincipal.getRole());
        claims.put("phoneNumber", userPrincipal.getPhoneNumber());
        claims.put("authorities", userPrincipal.getAuthorities());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .setId(jti)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String generateRefreshToken(Authentication authentication, String jti, String ati) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION * 2);
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

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
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
        HashMap<String, String> result = new HashMap<>();
        result.put("jti", jti);
        result.put("token", this.generateAccessToken(authentication, jti));
        return result;
    }

    private Map<String, String> createRefreshToken(Authentication authentication, String ati) {
        String jti = UUID.randomUUID().toString();
        HashMap<String, String> result = new HashMap<>();
        result.put("jti", jti);
        result.put("token", this.generateRefreshToken(authentication, ati, jti));
        return result;
    }
}

