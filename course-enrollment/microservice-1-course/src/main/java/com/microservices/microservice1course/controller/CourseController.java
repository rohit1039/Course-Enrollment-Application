package com.microservices.microservice1course.controller;

import com.microservices.microservice1course.entity.Course;
import com.microservices.microservice1course.exception.CourseNotFoundException;
import com.microservices.microservice1course.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
@Slf4j
public class CourseController
{
    @Autowired
    private CourseService courseService;

    @PostMapping("/save/course")
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel<Course> saveCourse(@Valid @RequestBody Course course)
    {
        log.info("inside saveCourse method");
        Course savedCourse = courseService.saveCourse(course);
        EntityModel<Course> model = EntityModel.of(savedCourse);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getCourses());
        model.add(link.withRel("all-courses").withHref("http://localhost:5555/gateway/course"));
        return model;
    }

    @GetMapping("/get/allcourses")
    public ResponseEntity<?> getCourses()
    {
        List<Course> courseList = courseService.findAllCourses();
        if (courseList.isEmpty())
        {
            throw new CourseNotFoundException("No courses available!");
        }
        log.info("inside getCourses method");
        return ResponseEntity.ok(courseList);
    }

    @DeleteMapping("/delete/course/{courseId}")
    public ResponseEntity<?> deleteCourseById(@PathVariable("courseId") Long courseID)
    {
        log.info("inside deleteCourseById method");
        courseService.deleteCourse(courseID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
