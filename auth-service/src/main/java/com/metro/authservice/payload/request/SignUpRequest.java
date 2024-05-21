package com.metro.authservice.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {
    @NotBlank(message = "User Name should not be blank!")
    @Length(min = 8)
    private String username;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",
            message = "Enter Correct Email!")
    @NotBlank(message = "Email should not be blank!")
    private String email;

    @NotBlank(message = "Password should not be blank!")
    @Length(min = 8, message = "Password length should be minimum 8 characters!")
    private String password;
}