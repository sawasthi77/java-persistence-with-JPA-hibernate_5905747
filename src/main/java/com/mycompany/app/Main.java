package com.mycompany.app;

import com.mycompany.app.entities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("artclass_persistence_unit");

    // create(emf);
    update(emf);
    attachAndDetach(emf);
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

  }

  private static void attachAndDetach(EntityManagerFactory emf) {

  }

  private static void remove(EntityManagerFactory emf) {

  }

}