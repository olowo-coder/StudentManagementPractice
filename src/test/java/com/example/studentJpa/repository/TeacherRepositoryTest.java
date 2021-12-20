package com.example.studentJpa.repository;

import com.example.studentJpa.entity.Course;
import com.example.studentJpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("Math")
                .credit(90)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(90)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Mark")
                .lastName("Ted")
                //.courses(List.of(course, courseJava))
                .build();

        repository.save(teacher);
    }

}