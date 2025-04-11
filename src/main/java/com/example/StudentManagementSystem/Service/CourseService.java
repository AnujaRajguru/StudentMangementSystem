package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.Repository.CourseRepository;
import com.example.StudentManagementSystem.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {

        this.courseRepository = courseRepository;
    }


    public List<Course> addCourse(List<Course> course) {

        return courseRepository.saveAll(course);
    }

}
