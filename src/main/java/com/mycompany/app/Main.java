package com.mycompany.app;

import java.util.List;
import com.mycompany.app.entities.ArtClass;
import com.mycompany.app.entities.Review;
import com.mycompany.app.entities.Student;
import com.mycompany.app.entities.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("artclass_persistence_unit");

    // create(emf);
    // update(emf);
    // attachAndDetach(emf);
    // remove(emf);
    oneToOneRelationship(emf);
    oneToManyRelationship(emf);
    manyToManyRelationship(emf);
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

  private static void oneToOneRelationship(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();

      ArtClass c = new ArtClass();
      c.setName("Oil Painting");
      c.setDayOfWeek("Monday");

      Teacher t = new Teacher();
      t.setName("Brown");

      c.setTeacher(t);

      em.persist(c);
      em.persist(t);

      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }

  private static void oneToManyRelationship(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();

      Teacher t = new Teacher();
      t.setName("Woods");

      Review r1 = new Review();
      r1.setComment("Excellent!");
      r1.setRating(5);
      r1.setTeacher(t);

      Review r2 = new Review();
      r2.setComment("Good!");
      r2.setRating(4);
      r2.setTeacher(t);

      t.setReviews(List.of(r1, r2));

      em.persist(t);

      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }

  private static void manyToManyRelationship(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();

      ArtClass c1 = new ArtClass();
      c1.setName("Recycled Scrap Art");
      c1.setDayOfWeek("Tuesday");

      ArtClass c2 = new ArtClass();
      c2.setName("Drawing Hands");
      c2.setDayOfWeek("Wednesday");

      Teacher t1 = new Teacher();
      t1.setName("White");

      Teacher t2 = new Teacher();
      t2.setName("Wood");

      c1.setTeacher(t1);
      c2.setTeacher(t2);

      Student s1 = new Student();
      s1.setName("Anne");
      Student s2 = new Student();
      s2.setName("Martin");

      c1.setStudents(List.of(s1, s2));
      c2.setStudents(List.of(s1, s2));

      em.persist(c1);
      em.persist(c2);

      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }
}