package com.microservices.microservice1course.repository;

import com.microservices.microservice1course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>
{

}
