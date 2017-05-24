package com.sensors.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Device implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String token;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Device(Long id, String token, User user) {
		super();
		this.id = id;
		this.token = token;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@JsonIgnore
	public User getUser() {
		return user;
	}

	@JsonSetter
	public void setUser(User user) {
		this.user = user;
	}

}
