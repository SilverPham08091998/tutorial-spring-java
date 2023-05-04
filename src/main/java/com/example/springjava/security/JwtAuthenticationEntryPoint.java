package com.example.springjava.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private static final Logger logger = LogManager.getLogger(JwtAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        if (e instanceof InsufficientAuthenticationException) {
            httpServletResponse.sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION,
                    e.getLocalizedMessage());
            logger.error("SC_NON_AUTHORITATIVE_INFORMATION Responding with unauthorized error. Message - {}", e.getMessage());
            return;
        }
        if (e instanceof DisabledException) {
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN,
                    e.getLocalizedMessage());
            logger.error("SC_FORBIDDEN Responding with unauthorized error. Message - {}", e.getMessage());
            return;
        }
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                e.getLocalizedMessage());
        logger.error("SC_UNAUTHORIZED Responding with unauthorized error. Message - {}", e.getMessage());

    }
}
