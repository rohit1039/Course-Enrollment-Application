package com.microservices.microservice3apigateway.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder implements ErrorDecoder
{
    @Override
    public Exception decode(String methodKey, Response response)
    {
        if (response.status() >= 400 && response.status() <= 500)
        {
            if (methodKey.contains("saveCourse"))
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Cannot save course!");
            else if (methodKey.contains("savePurchase"))
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), "This course cannot be purchased!");
            else if (methodKey.contains("getAllPurchasesOfAuthorizedUser"))
                return new ResponseStatusException(HttpStatus.NOT_FOUND, "Purchase doesn't exist!");
            else if (methodKey.contains("deleteCourseById"))
                return new ResponseStatusException(HttpStatus.NOT_FOUND, "Course doesn't exist!");
            else if (methodKey.contains("getAllCourses"))
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), "No course found!");
        } else
        {
            return new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Please wait...Services are not yet up!");
        }
        return new Exception(response.reason());
    }
}
