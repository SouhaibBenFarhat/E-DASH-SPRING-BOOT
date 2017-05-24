package com.sensors.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Arome implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String arome;
	private String imageUrl;
	private String description;
	private String date;
	private Boolean enabled;
	@ManyToOne
	private Manufacture manufacture;
	@ManyToOne
	private Category category;
	@OneToOne
	private User user;

	public Arome() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Arome(Long id, String arome, String imageUrl, Category category, String description, String date,
			Manufacture manufacture, User user, Boolean enabled) {
		super();
		this.id = id;
		this.arome = arome;
		this.imageUrl = imageUrl;
		this.category = category;
		this.description = description;
		this.date = date;
		this.manufacture = manufacture;
		this.user = user;
		this.enabled = enabled;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArome() {
		return arome;
	}

	public void setArome(String arome) {
		this.arome = arome;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
	

}
