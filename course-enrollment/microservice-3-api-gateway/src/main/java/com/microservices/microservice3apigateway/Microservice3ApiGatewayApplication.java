package com.microservices.microservice3apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Microservice3ApiGatewayApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(Microservice3ApiGatewayApplication.class, args);
    }

}
