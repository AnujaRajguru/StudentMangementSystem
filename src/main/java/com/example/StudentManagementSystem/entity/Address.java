
package com.example.StudentManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.StudentManagementSystem.entity.Student;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
