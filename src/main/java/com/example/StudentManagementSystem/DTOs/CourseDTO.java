package com.example.StudentManagementSystem.DTOs;

import com.example.StudentManagementSystem.entity.Course;
import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO{
    @Id
    private Long id;

    private String courseName;

    private String description;

    private String courseType;

    private String duration;

    private List<TopicsDTO> topics;

    private Set<StudentDTO> students = new HashSet<>();

}
