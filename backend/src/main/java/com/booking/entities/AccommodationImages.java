package com.booking.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;







@Entity
@Table(name="accommodationImages")
public class AccommodationImages
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name="path")
  private String path;
  @ManyToOne
  @JoinColumn(name="accommodation_id", nullable=false)
  @JsonBackReference
  private Accommodation accommodationId;
  @Column(name="uploadDate")
  private Date uploadDate;
  
  public AccommodationImages() {}
  
  public Long getId()
  {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getPath() {
    return path;
  }
  
  public void setPath(String path) {
    this.path = path;
  }
  
  public Accommodation getAccommodationId() {
    return accommodationId;
  }
  
  public void setAccommodationId(Accommodation accommodationId) {
    this.accommodationId = accommodationId;
  }
  
  public Date getUploadDate() {
    return uploadDate;
  }
  
  public void setUploadDate(Date uploadDate) {
    this.uploadDate = uploadDate;
  }
}

