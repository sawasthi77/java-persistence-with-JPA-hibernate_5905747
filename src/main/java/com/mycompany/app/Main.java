package com.mycompany.app;

import java.util.List;
import com.mycompany.app.entities.ArtClass;
import com.mycompany.app.entities.Review;
import com.mycompany.app.entities.Student;
import com.mycompany.app.entities.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("artclass_persistence_unit");

    // create(emf);
    // update(emf);
    // attachAndDetach(emf);
    // remove(emf);
    // oneToOneRelationship(emf);
    // oneToManyRelationship(emf);
    // manyToManyRelationship(emf);
    writeQuerries(emf);
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

  private static void writeQuerries(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();

    try {
      String s1 = "SELECT s FROM Student s";
      TypedQuery<Student> q1 = em.createQuery(s1, Student.class);
      q1.getResultList().forEach(r -> System.out.println(r));

      String s2 = "SELECT c.students FROM ArtClass c WHERE c.dayOfWeek = 'Monday'";
      TypedQuery<Student> q2 = em.createQuery(s2, Student.class);
      q2.getResultList().forEach(r -> System.out.println(r));

      String s3 = "SELECT AVG(r.rating) FROM Review r WHERE r.teacher.name = 'White'";
      TypedQuery<Double> q3 = em.createQuery(s3, Double.class);
      System.out.println(q3.getSingleResult());

      String s4 = "SELECT t.name, AVG(r.rating) FROM Review r INNER JOIN r.teacher t GROUP BY t.name";
      TypedQuery<Object[]> q4 = em.createQuery(s4, Object[].class);
      q4.getResultList().forEach(r -> System.out.println(r[0] + " " + r[1]));

      String s5 = "SELECT t.name, AVG(r.rating) FROM Review r INNER JOIN r.teacher t GROUP BY t.name ORDER BY AVG(r.rating) DESC";
      TypedQuery<Object[]> q5 = em.createQuery(s5, Object[].class);
      q5.getResultList().forEach(r -> System.out.println(r[0] + " " + r[1]));

      String s6 = "SELECT t.name, AVG(r.rating) FROM Review r INNER JOIN r.teacher t GROUP BY t.name HAVING AVG(r.rating) > 3 ORDER BY AVG(r.rating) DESC";
      TypedQuery<Object[]> q6 = em.createQuery(s6, Object[].class);
      q6.getResultList().forEach(r -> System.out.println(r[0] + " " + r[1]));

    } finally {
      em.close();
    }
  }
}