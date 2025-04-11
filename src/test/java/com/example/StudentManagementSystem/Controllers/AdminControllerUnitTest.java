package com.example.StudentManagementSystem.Controllers;

import com.example.StudentManagementSystem.Service.CourseService;
import com.example.StudentManagementSystem.Service.StudentService;
import com.example.StudentManagementSystem.entity.Student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AdminControllerUnitTest {

    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @Mock
    private CourseService courseService;

    @InjectMocks
    private AdminController controller;

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void initializeSetup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void saveStudentTest() throws Exception {
        Student testStudent = new Student();
        testStudent.setId(10L);
        testStudent.setName("Anuja");
        testStudent.setStudentCode("STU2025");

        when(studentService.addStudent(any(Student.class))).thenReturn(testStudent);

        mockMvc.perform(post("/api/admin/new-student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(testStudent)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentCode").value("STU2025"));
    }

    @Test
    void findStudentByNameTest() throws Exception {
        Student student = new Student();
        student.setName("Anuja");

        when(studentService.getStudentByName("Anuja")).thenReturn(Collections.singletonList(student));

        mockMvc.perform(get("/api/admin/students-name")
                        .param("studentName", "Anuja"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Anuja"));
    }

    @Test
    void fetchByCourseTest() throws Exception {
        Student student = new Student();
        student.setName("Ravi");

        when(studentService.getStudentsByCourse("Java")).thenReturn(List.of(student));

        mockMvc.perform(get("/api/admin/get-student-by-course")
                        .param("courseName", "Java"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Ravi"));
    }

}
