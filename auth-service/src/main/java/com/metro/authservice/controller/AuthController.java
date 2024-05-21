package com.metro.authservice.controller;

import com.metro.authservice.payload.request.SignInRequest;
import com.metro.authservice.payload.request.SignUpRequest;
import com.metro.authservice.payload.response.SignInResponse;
import com.metro.authservice.payload.response.SignUpResponse;
import com.metro.authservice.payload.response.TokenStatus;
import com.metro.authservice.repository.IAuthRepository;
import com.metro.authservice.service.IAuthService;
import com.metro.shared.entity.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.metro.constants.endpoints.AuthEndPoint.*;

@RestController
@RequestMapping(AUTH_BASE)
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;
    private final IAuthRepository authRepository;

    @PostMapping(AUTH_SIGNUP)
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok().body(authService.signUp(signUpRequest));
    }

    @PostMapping(AUTH_SIGNIN)
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok().body(authService.signIn(signInRequest));
    }

    @GetMapping(AUTH_VALIDATE)
    public ResponseEntity<TokenStatus> validateToken(@RequestParam("token") String token) {
        return ResponseEntity.ok().body(authService.validateToken(token));
    }

    @GetMapping
    public ResponseEntity<List<Users>> users() {
        return ResponseEntity.ok().body(authRepository.findAll());
    }
}