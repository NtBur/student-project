package com.spring_mvc.repository;

import com.spring_mvc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> students = session.createQuery("from Student", Student.class).getResultList();
        return students;
    }

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(student);
    }

    @Override
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery("delete from Student where id=:studentsId");
        query.setParameter("studentsId", id);
        query.executeUpdate();
    }
}
