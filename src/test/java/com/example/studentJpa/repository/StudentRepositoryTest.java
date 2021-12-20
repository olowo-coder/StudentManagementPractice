package com.example.studentJpa.repository;

import com.example.studentJpa.entity.Guardian;
import com.example.studentJpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder()
                .name("Sandra")
                .email("sandra@email.com")
                .phone("98765433")
                .build();

        Student student = Student.builder()
                .studentId(1L)
                .firstName("Daniel")
                .lastName("Alex")
                .email("daniel@email.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveAllStudent(){
        Guardian guardian1 = Guardian.builder()
                .name("sarah")
                .email("sarah@email.com")
                .phone("56765433")
                .build();

        Student student1 = Student.builder()
                .studentId(1L)
                .firstName("mercy")
                .lastName("steve")
                .email("steve@email.com")
                .guardian(guardian1)
                .build();


        Guardian guardian2 = Guardian.builder()
                .name("Pope")
                .email("pope@email.com")
                .phone("789433")
                .build();

        Student student2 = Student.builder()
                .studentId(1L)
                .firstName("paul")
                .lastName("john")
                .email("john@email.com")
                .guardian(guardian2)
                .build();

        System.out.println(studentRepository.saveAll(List.of(student1, student2)));

    }


    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList -> " + studentList);
    }

    @Test
    public void findByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Daniel");
        System.out.println("StudentList -> " + studentList);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("Dan");
        System.out.println("StudentList -> " + studentList);
    }

    @Test
    public void findByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Pope");
        System.out.println("StudentList -> " + studentList);
    }

    @Test
    public void getStudentByEmail(){
        Student student = studentRepository.getStudentByEmail("john@email.com");
        System.out.println("StudentList -> " + student);
    }

    @Test
    public void getStudentFirstNameByEmail(){
        String student = studentRepository.getStudentFirstNameByEmail("john@email.com");
        System.out.println("StudentList -> " + student);
    }

    @Test
    public void updateStudentFirstNameByEmail(){
        studentRepository.updateStudentIdByEmail("Issac","john@email.com");
    }
}