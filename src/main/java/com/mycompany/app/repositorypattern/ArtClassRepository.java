package com.mycompany.app.repositorypattern;

import com.mycompany.app.entities.ArtClass;

public interface ArtClassRepository {

  public void add(ArtClass artClass);

  public void update(ArtClass artClass);

  public void remove(ArtClass artClass);

  public ArtClass getClassById(Integer id);
}
