package com.example.StudentManagementSystem.DTOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicsDTO {
    private Long id;

    private String topicName;

    private Set<StudentDTO> students = new HashSet<>();

}
