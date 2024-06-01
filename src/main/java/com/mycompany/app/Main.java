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
      Student s = new Student();
      s.setName("John");

      em.persist(s);
      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }

  private static void update(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student s = em.find(Student.class, 1);
      s.setName("Peter");

      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }

  private static void attachAndDetach(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();

      Student s2 = new Student();
      s2.setName("Mary");
      em.merge(s2);
      em.detach(s2);
      s2.setName("Sue");

      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }

  private static void remove(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();
      Student s = em.find(Student.class, 1);
      em.remove(s);

      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }
}