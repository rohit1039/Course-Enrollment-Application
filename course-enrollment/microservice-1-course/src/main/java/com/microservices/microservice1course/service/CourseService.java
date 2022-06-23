package com.microservices.microservice1course.service;

import com.microservices.microservice1course.entity.Course;

import java.util.List;

public interface CourseService
{
    Course saveCourse(Course course);

    void deleteCourse(Long id);

    List<Course> findAllCourses();
}
