package com.sensors.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Base implements Serializable {

	
	@Id
	@GeneratedValue
	private Long id;
	private String pg;
	private String vg;
	private String nicotine;
	private String date;
	private String description;
	private String imageUrl;
	private String mobileImageUrl;
	public Base() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Base(Long id, String pg, String vg, String nicotine,String date, String description, String imageUrl, String mobileImageUrl) {
		super();
		this.id = id;
		this.pg = pg;
		this.vg = vg;
		this.nicotine = nicotine;
		this.description = description;
		this.date = date;
		this.imageUrl = imageUrl;
		this.mobileImageUrl  = mobileImageUrl;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPg() {
		return pg;
	}
	public void setPg(String pg) {
		this.pg = pg;
	}
	public String getVg() {
		return vg;
	}
	public void setVg(String vg) {
		this.vg = vg;
	}
	public String getNicotine() {
		return nicotine;
	}
	public void setNicotine(String nicotine) {
		this.nicotine = nicotine;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getMobileImageUrl() {
		return mobileImageUrl;
	}
	public void setMobileImageUrl(String mobileImageUrl) {
		this.mobileImageUrl = mobileImageUrl;
	}
	
	
	
	
	
}
