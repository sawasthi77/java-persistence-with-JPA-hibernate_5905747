package com.mycompany.app;

import com.mycompany.app.entities.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");

    createInstance(emf);

  }

  private static void createInstance(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager(); // Represent the persistence context

    try {
      em.getTransaction().begin();

      Book b = new Book();
      b.setName("my book3");
      b.setIsbn("333-456");
      em.persist(b);

      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }

}
