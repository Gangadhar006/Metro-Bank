package com.metro.authservice.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpResponse {
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
}
