package com.sensors.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DeviceConfig {

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
	private int deviceConfigTag;
	@ManyToOne
	private Base base;
	@ManyToOne
	private User user;
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<AromaPerRecipe> aromes;

	public DeviceConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceConfig(Long id, String note, String date, String name, Float baseQuantity, Float volume,
			Float totalAromeQuantity, int deviceConfigTag, Boolean visibility, Base base, User user,
			List<AromaPerRecipe> aromes, Boolean isDefault) {
		super();
		this.id = id;
		this.note = note;
		this.date = date;
		this.name = name;
		this.baseQuantity = baseQuantity;
		this.volume = volume;
		this.totalAromeQuantity = totalAromeQuantity;
		this.visibility = visibility;
		this.base = base;
		this.user = user;
		this.aromes = aromes;
		this.isDefault = isDefault;
		this.deviceConfigTag = deviceConfigTag;

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

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public int getDeviceConfigTag() {
		return deviceConfigTag;
	}

	public void setDeviceConfigTag(int deviceConfigTag) {
		this.deviceConfigTag = deviceConfigTag;
	}
	

}
