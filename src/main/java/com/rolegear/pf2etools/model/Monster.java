package com.rolegear.pf2etools.model;

import jakarta.persistence.*;

@Entity
@Table(name = "monsters")
public class Monster {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column
  private String type;

  @Column
  private int hitPoints;

  @Column
  private int armorClass;

  public Monster() {
  }

  public Monster(String name, String type, int hitPoints, int armorClass) {
    this.name = name;
    this.type = type;
    this.hitPoints = hitPoints;
    this.armorClass = armorClass;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getHitPoints() {
    return hitPoints;
  }

  public void setHitPoints(int hitPoints) {
    this.hitPoints = hitPoints;
  }

  public int getArmorClass() {
    return armorClass;
  }

  public void setArmorClass(int armorClass) {
    this.armorClass = armorClass;
  }
}
