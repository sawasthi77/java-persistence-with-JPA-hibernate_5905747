package com.mycompany.app;

import com.mycompany.app.entities.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");

    EntityManager em = emf.createEntityManager();
    try{
      em.getTransaction().begin();
      Book book = new Book();
      book.setId(123);
      book.setName("first");

      em.persist(book);
      em.getTransaction().commit();
    }finally{
      em.close();
    }
  }
}