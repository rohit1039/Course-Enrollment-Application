package com.microservices.microservice3apigateway.service;

import com.microservices.microservice3apigateway.model.Role;
import com.microservices.microservice3apigateway.model.User;

import java.util.Optional;

public interface UserService
{
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
