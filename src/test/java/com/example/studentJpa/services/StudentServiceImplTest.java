package com.example.studentJpa.services;

import com.example.studentJpa.entity.Student;
import com.example.studentJpa.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .studentId(1L)
                .firstName("alexander")
                .lastName("piper")
                .email("piper@email.com")
                .build();
    }

    @Test
    void getAllStudents() {
    }

    @Test
    void shouldSaveStudent() {
        // mock StudentRepository
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        //Call the method to be tested
        studentService.saveStudent(student);

        //Make Assertion

        verify(studentRepository, times(1)).save(any(Student.class));
    }

    @Test
    void getStudentId() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void removeStudent() {
    }
}