package com.sensors.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private double prix;
	private Date creationDate;
	private String imageUrl;
	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
	private Collection<Note> notes;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double prix, Date creationDate) {
		super();
		this.name = name;
		this.prix = prix;
		this.creationDate = creationDate;
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Collection<Note> getNotes() {
		return notes;
	}

	public void setNotes(Collection<Note> notes) {
		this.notes = notes;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

}
