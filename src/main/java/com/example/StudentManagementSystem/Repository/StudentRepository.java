package com.example.StudentManagementSystem.Repository;

import com.example.StudentManagementSystem.DTOs.StudentDTO;
import com.example.StudentManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameIgnoreCase(String name);

    List<Student> findByCourses_CourseNameIgnoreCase(String courseName);

    Optional<Student> findByStudentCode(String studentCode);
    Optional<Student> findByStudentCodeAndDateOfBirth(String studentCode, LocalDate dob);
}
