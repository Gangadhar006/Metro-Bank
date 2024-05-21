package com.metro.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static com.metro.constants.SecurityConstants.AUTH_URL;

@Component
public class RouteValidator {

    public Predicate<ServerHttpRequest> isSecured =
            request -> Arrays.stream(AUTH_URL).noneMatch(uri -> request.getURI().getPath().contains(uri));
}