package com.mycompany.app.repositorypattern;

import java.util.List;

import com.mycompany.app.dto.TeacherAvgRating;
import com.mycompany.app.entities.Review;

public interface ReviewRepository {
  public void add(Review review);

  public void update(Review review);

  public void remove(Review review);

  public Double getAvgRatingForTeacher(String teacher);

  public List<TeacherAvgRating> getAvgRatingsByTeachers();

}
