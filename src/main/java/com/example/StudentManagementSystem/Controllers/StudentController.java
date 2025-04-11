package com.example.StudentManagementSystem.Controllers;

import com.example.StudentManagementSystem.DTOs.StudentDTO;
import com.example.StudentManagementSystem.Service.StudentService;
import com.example.StudentManagementSystem.entity.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService  studentService;

    public StudentController(StudentService studentService){

        this.studentService = studentService;
    }


    @PatchMapping("/update-student-data/{studentCode}")
    public Student UpdateStudentProfil(@PathVariable("studentCode") String studentCode, @RequestBody Student student){
        return studentService.updateStudentProfile(studentCode,student);
    }

    @PostMapping("leave-course/{studentCode}/{courseName}")
    public Student leaveCourse(@PathVariable String studentCode, @PathVariable String courseName) {
        return studentService.leaveTheCourse(studentCode, courseName);
    }


}
