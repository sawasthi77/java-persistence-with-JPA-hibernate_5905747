package com.mycompany.app.entities;

import java.util.List;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "student_id")
  private int id;

  @Column(name = "student_name")
  private String name;

  @ManyToMany(mappedBy = "students")
  private List<ArtClass> classes;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<ArtClass> getClasses() {
    return classes;
  }

  public void setClasses(List<ArtClass> classes) {
    this.classes = classes;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + "]";
  }

}
