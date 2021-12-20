package com.example.studentJpa.repository;

import com.example.studentJpa.entity.Course;
import com.example.studentJpa.entity.Teacher;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository repository;

    @Test
    public void printAllCourse(){
        List<Course> courseList = repository.findAll();
        System.out.println(courseList);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .lastName("Clinton")
                .firstName("bush")
                .build();
        Course course = Course.builder()
                .title("python")
                .credit(95)
                .teacher(teacher)
                .build();

        repository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstWithThree = (Pageable) PageRequest.of(0, 3);
        Pageable secondWithTwo = (Pageable) PageRequest.of(1, 2);

        List<Course> courses = repository.findAll((PageRequest) firstWithThree).getContent();

        long totalElements = repository.findAll((PageRequest) firstWithThree).getTotalElements();

        long totalPages = repository.findAll((PageRequest) firstWithThree).getTotalPages();

        System.out.println("elements = " + totalElements);

        System.out.println("pages = " + totalPages);

        System.out.println("Courses = " + courses);

    }
}