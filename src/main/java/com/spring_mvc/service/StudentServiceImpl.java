package com.spring_mvc.service;

import com.spring_mvc.entity.Student;
import com.spring_mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
    @Override
    @Transactional
    public void saveStudent(Student student){
        studentRepository.saveStudent(student);
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        return studentRepository.getStudent(id);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }
}
