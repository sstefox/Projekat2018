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
@Table(name="reservations")
public class Reservations
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name="fromDate")
  private Date fromDate;
  @Column(name="toDate")
  private Date toDate;
  @Column(name="price")
  private Double price;
  @Column(name="status")
  private int status;
  @ManyToOne
  @JoinColumn(name="accommodation_id", nullable=false)
  @JsonBackReference
  private Accommodation accommodationId;
  @ManyToOne
  @JoinColumn(name="user_id", nullable=false)
  @JsonBackReference
  private User userId;
  @Column(name="capacity")
  private Double capacity;
  
  public Reservations() {}
  
  public Double getCapacity()
  {
    return capacity;
  }
  
  public void setCapacity(Double capacity) {
    this.capacity = capacity;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Date getFromDate() {
    return fromDate;
  }
  
  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }
  
  public Date getToDate() {
    return toDate;
  }
  
  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }
  
  public Double getPrice() {
    return price;
  }
  
  public void setPrice(Double price) {
    this.price = price;
  }
  
  public int getStatus() {
    return status;
  }
  
  public void setStatus(int status) {
    this.status = status;
  }
  
  public Accommodation getAccommodationId() {
    return accommodationId;
  }
  
  public void setAccommodationId(Accommodation accommodationId) {
    this.accommodationId = accommodationId;
  }
  
  public User getUserId() {
    return userId;
  }
  
  public void setUserId(User userId) {
    this.userId = userId;
  }
}
 
