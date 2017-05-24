package com.sensors.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RecipeRating {

	
	@Id
	@GeneratedValue
	private Long id;
	private Long value;
	@OneToOne
	private User user;
	@ManyToOne
	private Recipe recipe;
	public RecipeRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecipeRating(Long id, Long value, User user, Recipe recipe) {
		super();
		this.id = id;
		this.value = value;
		this.user = user;
		this.recipe = recipe;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
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
