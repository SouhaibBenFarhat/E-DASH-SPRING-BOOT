package com.sensors.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Manufacture implements Serializable {

	
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private String imageUrl;
	private String address;
	private String date;
	private float lang;
	private float lat;
	public Manufacture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manufacture(Long id, String name, String description, String imageUrl, String address, String date, float lang,float lat) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.address = address;
		this.date = date;
		this.lang = lang;
		this.lat= lat;
	}
	public Long getId() {
		return id;
	}
	@JsonSetter
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getLang() {
		return lang;
	}
	public void setLang(float lang) {
		this.lang = lang;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	
	
}


