package com.example.StudentManagementSystem.Controllers;

import com.example.StudentManagementSystem.Service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){

        this.courseService = courseService;
    }

}
