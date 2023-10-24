package com.spring_mvc.repository;

import com.spring_mvc.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
