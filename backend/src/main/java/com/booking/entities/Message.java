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
@Table(name="messages")
public class Message
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name="message", length=5000)
  private String message;
  @ManyToOne
  @JoinColumn(name="from_user", nullable=false)
  @JsonBackReference
  private User fromUser;
  @ManyToOne
  @JoinColumn(name="to_user", nullable=false)
  @JsonBackReference
  private User toUser;
  @Column(name="entryDate")
  private Date entryDate;
  @Column(name="status")
  private int status;
  @ManyToOne
  @JoinColumn(name="accommodation_id", nullable=false)
  @JsonBackReference
  private Accommodation accommodation;
  
  public Message() {}
  
  public Long getId()
  {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getComment() {
    return message;
  }
  
  public void setComment(String comment) {
    message = comment;
  }
  
  public User getFromUser() {
    return fromUser;
  }
  
  public void setFromUser(User fromUser) {
    this.fromUser = fromUser;
  }
  
  public User getToUser() {
    return toUser;
  }
  
  public void setToUser(User toUser) {
    this.toUser = toUser;
  }
  
  public Date getEntryDate() {
    return entryDate;
  }
  
  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }
  
  public int getStatus() {
    return status;
  }
  
  public void setStatus(int status) {
    this.status = status;
  }
  
  public Accommodation getAccommodation() {
    return accommodation;
  }
  
  public void setAccommodation(Accommodation accommodation) {
    this.accommodation = accommodation;
  }
}
 
