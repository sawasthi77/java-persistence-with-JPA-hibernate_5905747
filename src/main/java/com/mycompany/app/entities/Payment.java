package com.mycompany.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {

  @Id
  private int id;

  private double amount;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

}
