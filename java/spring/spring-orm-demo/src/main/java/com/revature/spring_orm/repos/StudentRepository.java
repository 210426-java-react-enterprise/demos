package com.revature.spring_orm.repos;

import com.revature.spring_orm.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Student> findAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student", Student.class).getResultList();
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public Student findStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Transactional
    public Student findStudentByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student s where s.email = :email", Student.class)
                      .setParameter("email", email)
                      .getSingleResult();
    }

    @Transactional(readOnly = true)
    public List<Student> findStudentsByLastName(String lastName) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student s where s.lastName = :lastName", Student.class)
                      .setParameter("lastName", lastName)
                      .getResultList();
    }

    @Transactional
    public Student save(Student newStudent) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newStudent);
        return newStudent;
    }

}
