package com.example.StudentManagementSystem.Repository;

import com.example.StudentManagementSystem.DTOs.CourseDTO;
import com.example.StudentManagementSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    public Optional<Course> findByCourseName(String courseName);

}
