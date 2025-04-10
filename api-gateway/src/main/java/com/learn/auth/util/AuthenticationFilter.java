package com.learn.auth.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("AuthenticationFilter")
@Order(-1)
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
        System.out.println("✅ AuthenticationFilter initialized");
    }

    @Override
    public GatewayFilter apply(Config config) {
        System.out.println("🔄 Filter apply() triggered");

        return (exchange, chain) -> {
            System.out.println("🟡 Inside the filter logic...");
            // 👇 Check if path starts with /auth
            String path = exchange.getRequest().getURI().getPath();
            System.out.println("🚀 Authentication filter triggered for path: " + path);

            if (path.startsWith("/auth")) {
                // Skip authentication for /auth/** routes (like /auth/login)
                return chain.filter(exchange);
            }

            // 🔒 Token validation for protected routes
            String token = Optional.ofNullable(exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION))
                    .filter(h -> h.startsWith("Bearer "))
                    .map(h -> h.substring(7))
                    .orElse(null);

            if (token == null) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
            System.out.println("🔐 Token: " + token);
            try {
                jwtUtil.validateTokenAndRetrieveSubject(token);
            } catch (Exception e) {
                System.err.println("❌ Invalid JWT: " + e.getMessage());
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        };
    }

    public static class Config {
        // For future config if needed
    }
}
