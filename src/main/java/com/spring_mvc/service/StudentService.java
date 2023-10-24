package com.spring_mvc.service;

import com.spring_mvc.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudent(int id);
    void deleteStudent(int id);
}
