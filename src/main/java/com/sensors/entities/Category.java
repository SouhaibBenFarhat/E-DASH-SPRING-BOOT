package com.sensors.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category implements Serializable {

	
	@Id
	@GeneratedValue
	private Long id;
	private String category;
	private String imageName;
	private String description;
	private String imageUrl;
	private String date;
	
	public Category(Long id, String category, String imageName, String description, String imageUrl, String date) {
		super();
		this.id = id;
		this.category = category;
		this.imageName = imageName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.date = date;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
