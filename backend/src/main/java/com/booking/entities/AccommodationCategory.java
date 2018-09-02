package com.booking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name="accommodationCategory")
public class AccommodationCategory
{
  @Id
  @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
  private Long id;
  @Column(name="categoryName")
  private String categoryName;
  
  public AccommodationCategory() {}
  
  public Long getId()
  {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getCategoryName() {
    return categoryName;
  }
  
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}

