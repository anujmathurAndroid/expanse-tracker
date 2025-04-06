package com.learn.auth.util;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final String secret = "secret123";
    public String validateTokenAndRetrieveSubject(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
}


