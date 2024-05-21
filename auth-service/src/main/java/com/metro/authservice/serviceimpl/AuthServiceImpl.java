package com.metro.authservice.serviceimpl;

import com.metro.authservice.payload.request.SignInRequest;
import com.metro.authservice.payload.request.SignUpRequest;
import com.metro.authservice.payload.response.SignInResponse;
import com.metro.authservice.payload.response.SignUpResponse;
import com.metro.authservice.payload.response.TokenStatus;
import com.metro.authservice.repository.IAuthRepository;
import com.metro.authservice.service.IAuthService;
import com.metro.authservice.service.IJwtService;
import com.metro.shared.entity.user.Users;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final IAuthRepository authRepo;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final IJwtService jwtService;

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        Users user = mapper.map(signUpRequest, Users.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Users savedUser = authRepo.save(user);
        return mapper.map(savedUser, SignUpResponse.class);
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        String jwt;
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));

        if (authentication.isAuthenticated())
            jwt = jwtService.generateToken(signInRequest.getUsername());
        else throw new UsernameNotFoundException("Invalid username or password!");

        return SignInResponse.builder()
                .token(jwt)
                .build();
    }

    @Override
    public TokenStatus validateToken(String token) {
        TokenStatus tokenStatus = new TokenStatus();
        tokenStatus.setTokenValid(jwtService.validateToken(token));
        return tokenStatus;
    }
}
