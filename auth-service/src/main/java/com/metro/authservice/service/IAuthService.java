package com.metro.authservice.service;

import com.metro.authservice.payload.request.SignInRequest;
import com.metro.authservice.payload.request.SignUpRequest;
import com.metro.authservice.payload.response.SignInResponse;
import com.metro.authservice.payload.response.SignUpResponse;

public interface IAuthService {
    SignUpResponse signUp(SignUpRequest signUpRequest);

    SignInResponse signIn(SignInRequest signInRequest);

    String validateToken(String token);
}
