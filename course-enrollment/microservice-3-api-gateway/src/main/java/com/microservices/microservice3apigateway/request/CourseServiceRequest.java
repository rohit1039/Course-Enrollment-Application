package com.microservices.microservice3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "course-service", path = "/api")
public interface CourseServiceRequest
{
    @PostMapping("/save/course")
    Object saveCourse(@RequestBody Object requestBody);

    @DeleteMapping("/delete/course/{courseId}")
    void deleteCourseById(@PathVariable("courseId") Long courseId);

    @GetMapping("/get/allcourses")
    List<Object> getAllCourses();
}

