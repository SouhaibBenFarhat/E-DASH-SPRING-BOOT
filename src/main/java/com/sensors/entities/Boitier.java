package com.sensors.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Boitier {

	
	@Id
	@GeneratedValue
	private Long id;
	private String macAddress;
	private String date;
	private Boolean enabled;
	public Boitier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Boitier(Long id, String macAddress, String date, Boolean enabled) {
		super();
		this.id = id;
		this.macAddress = macAddress;
		this.date = date;
		this.enabled = enabled;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
}
