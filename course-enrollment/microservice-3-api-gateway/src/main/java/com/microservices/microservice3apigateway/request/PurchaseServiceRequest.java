package com.microservices.microservice3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "purchase-service", //microservice-application-name
        path = "/api", //pre-path for service endpoints
        configuration = FeignConfiguration.class)
public interface PurchaseServiceRequest
{
    @PostMapping("/save/purchase")
    Object savePurchase(@RequestBody Object requestBody);

    @GetMapping("/get/purchase/{userId}")
    List<Object> getAllPurchasesOfUser(@PathVariable("userId") Long userId);
}
