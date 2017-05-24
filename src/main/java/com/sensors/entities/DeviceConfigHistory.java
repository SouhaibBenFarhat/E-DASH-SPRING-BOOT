package com.sensors.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DeviceConfigHistory {

	@Id
	@GeneratedValue
	private Long id;
	private String note;
	private String date;
	private String name;
	private Float baseQuantity;
	private Float volume;
	private Float totalAromeQuantity;
	private Boolean visibility;
	private Boolean isDefault;
	@ManyToOne
	private Base base;
	@ManyToOne
	private User user;

	@OneToMany(cascade=CascadeType.REMOVE)
	private List<AromaPerRecipe> aromes;
	public DeviceConfigHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviceConfigHistory(Long id, String note, String date, String name, Float baseQuantity, Float volume,
			Float totalAromeQuantity, Boolean visibility, Boolean isDefault, Base base, User user, List<AromaPerRecipe> aromes) {
		super();
		this.id = id;
		this.note = note;
		this.date = date;
		this.name = name;
		this.baseQuantity = baseQuantity;
		this.volume = volume;
		this.totalAromeQuantity = totalAromeQuantity;
		this.visibility = visibility;
		this.isDefault = isDefault;
		this.base = base;
		this.user = user;
		this.aromes = aromes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public Float getBaseQuantity() {
		return baseQuantity;
	}
	public void setBaseQuantity(Float baseQuantity) {
		this.baseQuantity = baseQuantity;
	}
	public Float getVolume() {
		return volume;
	}
	public void setVolume(Float volume) {
		this.volume = volume;
	}
	public Float getTotalAromeQuantity() {
		return totalAromeQuantity;
	}
	public void setTotalAromeQuantity(Float totalAromeQuantity) {
		this.totalAromeQuantity = totalAromeQuantity;
	}
	public Boolean getVisibility() {
		return visibility;
	}
	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}
	public Boolean getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
	public Base getBase() {
		return base;
	}
	public void setBase(Base base) {
		this.base = base;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public List<AromaPerRecipe> getAromes() {
		return aromes;
	}
	public void setAromes(List<AromaPerRecipe> aromes) {
		this.aromes = aromes;
	}
	
	
	
	
	
}
