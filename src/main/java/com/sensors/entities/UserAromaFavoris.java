package com.sensors.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserAromaFavoris {
	@Id
	@GeneratedValue
	private Long id;
	private String date;
	@ManyToOne
	private User user;
	@ManyToOne
	private Arome arome;
	public UserAromaFavoris(Long id, String date, User user, Arome arome) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
		this.arome = arome;
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
	public Arome getArome() {
		return arome;
	}
	public void setArome(Arome arome) {
		this.arome = arome;
	}
	
	
}
