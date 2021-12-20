package com.example.studentJpa.services;

import com.example.studentJpa.entity.Student;
import com.example.studentJpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }


    public Student getStudentId(Long Id) {
        return studentRepository.findById(Id).get();
    }


    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void removeStudent(Long id){
        studentRepository.deleteById(id);
    }
}
