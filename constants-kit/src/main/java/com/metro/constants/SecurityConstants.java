package com.metro.constants;

public class SecurityConstants {
    public static final String[] AUTH_URL = {
            "/api/auth/signin",
            "/api/auth/signup",
            "/api/auth/validate"
    };
    public static final String[] SWAGGER_URL = {
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/v3/api-docs/**"
    };
    public static final String[] USER_URL = {
            "/api/user/signup"
    };

    public static final String SECRET = "C1A3B219C5F6E874D5A37BC7F813E9D6CE0B3F7A51612E9B3B0346A791C04C6A";
    public static final long TOKEN_EXPIRATION = 1000 * 60 * 24;
    public static final String BEARER = "Bearer ";
}