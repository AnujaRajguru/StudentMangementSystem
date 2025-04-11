package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.DTOs.StudentDTO;
import com.example.StudentManagementSystem.Repository.StudentRepository;
import com.example.StudentManagementSystem.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    private final JWTTokenService jwtTokenService;

    private final StudentRepository studentRepository;

    public AuthenticationController(JWTTokenService jwtTokenService, StudentService studentService, StudentRepository studentRepository){

        this.jwtTokenService = jwtTokenService;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/admin/login")
    public ResponseEntity<?> adminLogin(@RequestParam String userName,@RequestParam String password){
        if(userName.equals(adminUsername) && password.equals(adminPassword)){
            String token = jwtTokenService.generateJWTToken(userName,"admin");
            return ResponseEntity.ok("Bearer "+ token);
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid admin credentials!");
        }
    }

    @PostMapping("student/login")
    public ResponseEntity<String> studentLogin(@RequestParam String studentCode, @RequestParam String dateOfBirth){
        Optional<Student> student = studentRepository.findByStudentCodeAndDateOfBirth(studentCode,LocalDate.parse(dateOfBirth));
        if(student.isPresent()){
            String token = jwtTokenService.generateJWTToken(studentCode,"student");
            return ResponseEntity.ok("Bearer " +  token);
        }
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Student Data!");


    }

}
