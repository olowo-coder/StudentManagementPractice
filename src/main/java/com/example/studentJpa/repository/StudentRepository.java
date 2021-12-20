package com.example.studentJpa.repository;

import com.example.studentJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String name);

    Student findStudentByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.email = ?1")
    Student getStudentByEmail(String email);

    @Query("select s.firstName from Student s where s.email = ?1")
    String getStudentFirstNameByEmail(String email);

    @Modifying
    @Transactional
    @Query("update Student s set s.email = ?1 where s.email = ?2")
    int updateStudentIdByEmail(String firstName, String email);

//    @Query(
//            value = "select * from student_table",
//            nativeQuery = true
//    )
//    Student getStudentByEmailNative(String email);
}
