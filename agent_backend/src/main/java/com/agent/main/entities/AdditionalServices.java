package com.agent.main.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "additionalServices")
public class AdditionalServices {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="serviceName")
	private String serviceName;

	
	@ManyToMany(mappedBy="services")
	@JsonBackReference
	private Set<Accommodation> accommodations = new HashSet<>();
	
	
	



	public Set<Accommodation> getAccommodations() {
		return accommodations;
	}

	public void setAccommodations(Set<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}

	public AdditionalServices() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
}
