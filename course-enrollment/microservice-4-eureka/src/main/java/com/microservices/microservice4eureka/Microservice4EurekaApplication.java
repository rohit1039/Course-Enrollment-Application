package com.microservices.microservice4eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Microservice4EurekaApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(Microservice4EurekaApplication.class, args);
    }

}
