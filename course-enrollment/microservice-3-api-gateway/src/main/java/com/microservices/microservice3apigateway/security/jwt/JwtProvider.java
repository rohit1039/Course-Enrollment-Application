package com.microservices.microservice3apigateway.security.jwt;

import com.microservices.microservice3apigateway.security.UserPrincipal;

public interface JwtProvider
{

    // generate token
    String generateToken(UserPrincipal auth);

    // get username from the token
    String getUsernameFromJWT(String token);


    // checking token valid or not
    boolean isTokenValid(String token);
}
