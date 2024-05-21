package com.metro.authservice.controller;

import com.metro.authservice.payload.request.SignInRequest;
import com.metro.authservice.payload.request.SignUpRequest;
import com.metro.authservice.payload.response.SignInResponse;
import com.metro.authservice.payload.response.SignUpResponse;
import com.metro.authservice.service.IAuthService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    @PostMapping("signup")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok().body(authService.signUp(signUpRequest));
    }

    @PostMapping("signin")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok().body(authService.signIn(signInRequest));
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam("token") String token) {
        return ResponseEntity.ok().body(authService.validateToken(token));
    }
    @GetMapping("/test")
    public String test(){
        return "Auth-Service";
    }
}