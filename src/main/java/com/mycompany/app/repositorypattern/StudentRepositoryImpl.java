package com.mycompany.app.repositorypattern;

import java.util.List;

import com.mycompany.app.entities.ArtClass;
import com.mycompany.app.entities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class StudentRepositoryImpl implements StudentRepository {

  private EntityManager em;

  public StudentRepositoryImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void add(Student student) {
    try {
      em.getTransaction().begin();
      em.persist(student);
      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Student student) {
    try {
      em.getTransaction().begin();
      Student s = em.find(Student.class, student.getId());
      if (!s.equals(student)) {
        s = student;
      }

      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remove(Student student) {
    try {
      em.getTransaction().begin();
      em.remove(student);
      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Student getStudentById(Integer id) {
    return em.find(Student.class, id);
  }

  @Override
  public List<Student> getAllStudents() {
    String s = "SELECT s FROM Student s";
    TypedQuery<Student> q = em.createQuery(s, Student.class);
    return q.getResultList();
  }

  @Override
  public List<Student> getStudentsForDay(String day) {
    String s = "SELECT c.students FROM ArtClass c WHERE c.dayOfWeek = :day";
    TypedQuery<Student> q = em.createQuery(s, Student.class);
    q.setParameter("day", day);
    return q.getResultList();
  }

}
