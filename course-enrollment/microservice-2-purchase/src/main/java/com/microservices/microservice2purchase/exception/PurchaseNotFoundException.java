package com.microservices.microservice2purchase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PurchaseNotFoundException extends RuntimeException
{
    public PurchaseNotFoundException(String msg)
    {
        super(msg);
    }
}
