package com.example.StudentManagementSystem.Controllers;

import com.example.StudentManagementSystem.Service.CourseService;
import com.example.StudentManagementSystem.entity.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){

        this.courseService = courseService;
    }

}
