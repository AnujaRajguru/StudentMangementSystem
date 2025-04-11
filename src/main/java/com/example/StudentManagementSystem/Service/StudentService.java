package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.Config.ModelMapperConfig;
import com.example.StudentManagementSystem.DTOs.CourseDTO;
import com.example.StudentManagementSystem.DTOs.StudentDTO;
import com.example.StudentManagementSystem.Repository.CourseRepository;
import com.example.StudentManagementSystem.Repository.StudentRepository;
import com.example.StudentManagementSystem.entity.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.StudentManagementSystem.entity.Student;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    //add student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }


    //find student by name
    public List<Student> getStudentByName(String studentName) {
        return studentRepository.findByNameIgnoreCase(studentName);
    }

    //find student by course id
    public List<Student> getStudentsByCourse(String courseName){
        return studentRepository.findByCourses_CourseNameIgnoreCase(courseName);
    }



    //student updating some profile information
    public Student updateStudentProfile(String studentCode, Student updatedetails) {

        Student s = studentRepository.findByStudentCode(studentCode)
                        .orElseThrow(() -> new ResourseNotFound("Student Not found : " + studentCode));

        s.setEmail(updatedetails.getEmail());
        s.setMobileNumber(updatedetails.getMobileNumber());
        s.setFathersName(updatedetails.getFathersName());
        s.setMothersName(updatedetails.getMothersName());

        return studentRepository.save(s);
    }

    //thrown custome runtime Exception
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ResourseNotFound extends RuntimeException{
        public  ResourseNotFound(String message){
            super(message);
        }
    }

    //handled runtime ResourseNotFound Exception
    @ExceptionHandler(ResourseNotFound.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(ResourseNotFound exc){
        Map<String,String> error = new HashMap<>();
        error.put("error" ,exc.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //student assign courses to themselves
    public Student assignCourse(String studentCode, String courseName) {
        Student student = studentRepository.findByStudentCode(studentCode)
                .orElseThrow(() -> new ResourseNotFound("Student Not found : " + studentCode));

        Course course = courseRepository.findByCourseName(courseName).
                orElseThrow(() -> new ResourseNotFound("Course Not found : " + courseName));

        student.getCourses().add(course);

        return studentRepository.save(modelMapper.map(student,Student.class));
    }

    //student can leave the course
    public Student leaveTheCourse(String studentCode, String courseName) {
        Student student = studentRepository.findByStudentCode(studentCode)
                .orElseThrow(() -> new ResourseNotFound("Student Not found : " + studentCode));
        Course course = courseRepository.findByCourseName(courseName)
                .orElseThrow(() -> new ResourseNotFound("Course Not found : " + courseName));
        student.getCourses().remove(course);
        return studentRepository.save(modelMapper.map(student,Student.class));
    }
}
