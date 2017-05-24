package com.sensors.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AromaPerRecipe implements Serializable {

	
	@Id
	@GeneratedValue
	private Long id;
	private Float quantity;
	private int position;
	@ManyToOne
	private Arome arome;

	public AromaPerRecipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AromaPerRecipe(Long id, Float quantity, Arome arome, int position) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.arome = arome;
		this.position = position;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Arome getArome() {
		return arome;
	}
	public void setArome(Arome arome) {
		this.arome = arome;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	

}
