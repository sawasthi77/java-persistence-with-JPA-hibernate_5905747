package com.mycompany.app.repositorypattern;

import com.mycompany.app.dto.TeacherAvgRating;
import com.mycompany.app.entities.Review;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ReviewRepositoryImpl implements ReviewRepository {

  private EntityManager em;

  public ReviewRepositoryImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void add(Review review) {
    try {
      em.getTransaction().begin();
      em.persist(review);
      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Review review) {
    try {
      em.getTransaction().begin();
      Review r = em.find(Review.class, review.getId());
      if (!r.equals(review)) {
        r = review;
      }

      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remove(Review review) {
    try {
      em.getTransaction().begin();
      em.remove(review);
      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Double getAvgRatingForTeacher(String teacher) {
    String s = "SELECT AVG(r.rating) FROM Review r WHERE r.teacher.name = :teacher";
    TypedQuery<Double> q = em.createQuery(s, Double.class);
    q.setParameter("teacher", teacher);
    return q.getSingleResult();
  }

  @Override
  public List<TeacherAvgRating> getAvgRatingsByTeachers() {
    String s = "SELECT NEW com.mycompany.app.dto.TeacherAvgRating(t.name, AVG(r.rating)) FROM Review r INNER JOIN r.teacher t GROUP BY t.name";
    TypedQuery<TeacherAvgRating> q = em.createQuery(s, TeacherAvgRating.class);
    return q.getResultList();
  }

}
