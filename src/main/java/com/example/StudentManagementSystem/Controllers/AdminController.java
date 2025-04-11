package com.example.StudentManagementSystem.Controllers;

import com.example.StudentManagementSystem.DTOs.StudentDTO;
import com.example.StudentManagementSystem.Service.CourseService;
import com.example.StudentManagementSystem.Service.StudentService;
import com.example.StudentManagementSystem.entity.Course;
import com.example.StudentManagementSystem.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final StudentService studentService;
    private final CourseService courseService;

    public AdminController(StudentService studentService, CourseService courseService){

        this.studentService = studentService;
        this.courseService = courseService;
    }

    //to add new student in student table
    @PostMapping("/new-student")
    public Student addNewStudentDetails(@RequestBody Student student){

        return studentService.addStudent(student);
    }


    @GetMapping("/students-name")
    public List<Student> getStudentByName(@RequestParam String studentName) {

        return studentService.getStudentByName(studentName);
    }

    @GetMapping("/get-student-by-course")
    public List<Student> getStudentsByCourse(@RequestParam String courseName){
        return studentService.getStudentsByCourse(courseName);
    }

    @PostMapping("add-new-courses")
    public List<Course> addCourses(@RequestBody List<Course> course){
        return courseService.addCourse(course);
    }

    @PostMapping("/assign-course/{studentCode}/{courseName}")
    public Student assigneCousreToStudent(@PathVariable String studentCode,@PathVariable String courseName){
        return studentService.assignCourse(studentCode,courseName);
    }

}
