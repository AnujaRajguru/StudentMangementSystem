
package com.example.StudentManagementSystem.DTOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.StudentManagementSystem.entity.Student;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressDTO {
    @Id
    private Long id;

    private String type;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    private Student student;

}
