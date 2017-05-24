package com.sensors.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRecipeFavoris {
	
	@Id
	@GeneratedValue
	private Long id;
	private String date;
	@ManyToOne
	private User user;
	@ManyToOne
	private Recipe recipe;
	public UserRecipeFavoris(Long id, String date, User user, Recipe recipe) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
		this.recipe = recipe;
	}
	public UserRecipeFavoris() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
	
	

}
