package com.example.studentJpa.services;

import com.example.studentJpa.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentId(Long Id);

    Student updateStudent(Student student);

    void removeStudent(Long id);
}
