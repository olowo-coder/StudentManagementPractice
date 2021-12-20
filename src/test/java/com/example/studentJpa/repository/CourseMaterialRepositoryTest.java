package com.example.studentJpa.repository;

import com.example.studentJpa.entity.Course;
import com.example.studentJpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial (){
        Course course = Course.builder()
                .title("Algorithm")
                .credit(80)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("wwww.google.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterialList = repository.findAll();
        System.out.println(courseMaterialList);
    }
}