package com.sensors.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Recipe implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String date;
	private String imageUrl;
	private String name;
	private String stip;
	private Float baseQuantity;
	private Float volume;
	private int comments;
	private int likes;
	private int votes;
	private Float totalAromeQuantity;
	private int recipeTag;
	@ManyToOne
	private Base base;
	@ManyToOne
	private User user;
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<AromaPerRecipe> aromes;

	public Recipe() {
		super();

	}

	public Recipe(Long id, String description, String date, String imageUrl, String name, String stip,
			List<AromaPerRecipe> aromes, Base base, Float volume, Float baseQuantity, Float totalAromeQuantity,
			User user, int comments,int recipeTag, int likes, int votes) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.imageUrl = imageUrl;
		this.name = name;
		this.stip = stip;
		this.aromes = aromes;
		this.base = base;
		this.volume = volume;
		this.baseQuantity = baseQuantity;
		this.totalAromeQuantity = totalAromeQuantity;
		this.user = user;
		this.comments = comments;
		this.likes = likes;
		this.votes = votes;
		this.recipeTag = recipeTag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStip() {
		return stip;
	}

	public void setStip(String stip) {
		this.stip = stip;
	}

	public List<AromaPerRecipe> getAromes() {
		return aromes;
	}

	public void setAromes(List<AromaPerRecipe> aromes) {
		this.aromes = aromes;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}

	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}

	public Float getBaseQuantity() {
		return baseQuantity;
	}

	public void setBaseQuantity(Float baseQuantity) {
		this.baseQuantity = baseQuantity;
	}

	public Float getTotalAromeQuantity() {
		return totalAromeQuantity;
	}

	public void setTotalAromeQuantity(Float totalAromeQuantity) {
		this.totalAromeQuantity = totalAromeQuantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getRecipeTag() {
		return recipeTag;
	}

	public void setRecipeTag(int recipeTag) {
		this.recipeTag = recipeTag;
	}
	
	

}
