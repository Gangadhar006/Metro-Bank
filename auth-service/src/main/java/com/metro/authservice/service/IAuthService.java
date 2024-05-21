package com.metro.authservice.service;

import com.metro.authservice.payload.request.SignInRequest;
import com.metro.authservice.payload.request.SignUpRequest;
import com.metro.authservice.payload.response.SignInResponse;
import com.metro.authservice.payload.response.SignUpResponse;
import com.metro.authservice.payload.response.TokenStatus;

public interface IAuthService {
    SignUpResponse signUp(SignUpRequest signUpRequest);

    SignInResponse signIn(SignInRequest signInRequest);

    TokenStatus validateToken(String token);
}
