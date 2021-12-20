package com.example.studentJpa.controller;

import com.example.studentJpa.entity.Student;
import com.example.studentJpa.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {
    private final StudentServiceImpl studentService;

    @Autowired
    public StudentRestController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

//    @GetMapping(value = "students/api", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "students/api", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> StudentInfo(){
        return studentService.getAllStudents();
    }
}
