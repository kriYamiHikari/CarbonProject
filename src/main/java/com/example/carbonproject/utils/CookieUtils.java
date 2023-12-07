package com.example.carbonproject.utils;

import com.example.carbonproject.config.JwtConfig;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class CookieUtils {
    private final JwtConfig jwtConfig;

    public CookieUtils(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public String getSubjectFromCookieToken(HttpServletRequest request) {
        String token = getCookieValue(request, jwtConfig.getHeader());
        return (token != null) ? jwtConfig.getSubject(token) : null;
    }
}
