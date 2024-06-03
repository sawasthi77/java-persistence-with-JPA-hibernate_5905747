package com.mycompany.app.repositorypattern;

import com.mycompany.app.entities.ArtClass;

import jakarta.persistence.EntityManager;

public class ArtClassRepositoryImpl implements ArtClassRepository {

  private EntityManager em;

  public ArtClassRepositoryImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void add(ArtClass artClass) {
    try {
      em.getTransaction().begin();
      em.persist(artClass);
      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(ArtClass artClass) {
    try {
      em.getTransaction().begin();
      ArtClass c = em.find(ArtClass.class, artClass.getId());
      if (!c.equals(artClass)) {
        c = artClass;
      }

      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remove(ArtClass artClass) {
    try {
      em.getTransaction().begin();
      em.remove(artClass);
      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public ArtClass getClassById(Integer id) {
    return em.find(ArtClass.class, id);
  }
}
