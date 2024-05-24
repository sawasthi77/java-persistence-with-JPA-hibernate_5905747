package com.mycompany.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("teacher")
public class Teacher2 extends Member2 {
  @Column(name = "teacher_code")
  private String teacherCode;

  public String getTeacherCode() {
    return teacherCode;
  }

  public void setTeacherCode(String teacherCode) {
    this.teacherCode = teacherCode;
  }
}
