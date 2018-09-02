package com.agent.main.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "accommodation")
public class Accommodation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="location")
	private String location;
	
	@Column(name="description")
	private String description;
	
	@Column(name="capacity")
	private int capacity;
	
	@Column(name="type")
	private String type;
	
	@Column(name="price")
	private double price;
	
	@Column(name="status")
	private int status;
	
	@Column(name="username")
	private String username;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	        name = "accommodation_service", 
	        joinColumns = { @JoinColumn(name = "acc_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "service_id") }
	    )
	@JsonManagedReference
	private Set<AdditionalServices> services;
	
	@Column(name = "rating")
	private Double rating;
	
	@Column(name="category")
	private int category;
	
	
	public Double getRating() {
		return rating;
	}




	public void setRating(Double rating) {
		this.rating = rating;
	}




	public int getCategory() {
		return category;
	}




	public void setCategory(int category) {
		this.category = category;
	}

	@OneToMany(targetEntity=AccommodationImages.class,mappedBy="accommodationId", 
			fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<AccommodationImages> accommodationImages;
	
	@OneToMany(targetEntity=Reservations.class,mappedBy="accommodationId", 
			fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Reservations> reservationList;
	
	
	
	
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}

	public Accommodation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	public Set<AdditionalServices> getServices() {
		return services;
	}




	public void setServices(Set<AdditionalServices> services) {
		this.services = services;
	}




	public List<AccommodationImages> getAccommodationImages() {
		return accommodationImages;
	}

	public void setAccommodationImages(List<AccommodationImages> accommodationImages) {
		this.accommodationImages = accommodationImages;
	}

	public List<Reservations> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservations> reservationList) {
		this.reservationList = reservationList;
	}
		
	
	
}
