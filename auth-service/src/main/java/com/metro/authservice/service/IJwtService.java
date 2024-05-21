package com.metro.authservice.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    String extractEmail(String token);

    String generateToken(String email);

    Boolean isTokenValid(String token, UserDetails userDetails);

    void validateToken(String token);
}