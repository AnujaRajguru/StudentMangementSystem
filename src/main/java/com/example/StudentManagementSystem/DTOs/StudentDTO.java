
package com.example.StudentManagementSystem.DTOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    @Id
    private Long id;

    private String name;

    private LocalDate dateOfBirth;

    private String gender;

    private String studentCode;

    private String email;

    private String mobileNumber;

    private String fathersName;

    private String mothersName;

    private List<AddressDTO> addresses = new ArrayList<>();

    private Set<CourseDTO> courses = new HashSet<>();
}
