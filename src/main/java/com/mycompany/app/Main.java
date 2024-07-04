package com.mycompany.app;

import com.mycompany.app.entities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("artclass_persistence_unit");

    // create(emf);
    // update(emf);
    // attachAndDetach(emf);
    remove(emf);
  }

  private static void create(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();
      Student student = new Student();
      student.setName("John");

      em.persist(student);
      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }

  private static void update(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student student = em.find(Student.class, 1);
      student.setName("Peter");

      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }

  private static void attachAndDetach(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student student2 = new Student();
      student2.setName("Mary");
      em.merge(student2);
      em.detach(student2);
      student2.setName("Sue");

      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }

  private static void remove(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();
      Student student = em.find(Student.class, 1);
      em.remove(student);

      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }
}