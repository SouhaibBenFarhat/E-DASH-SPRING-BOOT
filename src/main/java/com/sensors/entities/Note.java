package com.sensors.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonSubTypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@Entity

//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
//@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
//@JsonSubTypes({
//	@Type(name="CC",value=Product.class),
//	@Type(name"CE",value=Product.class)
//	
//})


public class Note implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String imageUrl;
	private Long prix;
	@ManyToMany
	private List<Product> products;
	
	@JsonIgnore
	public List<Product> getProducts() {
		return products;
	}

	@JsonSetter
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	private double quantity;

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Note(Long id, String name, String imageUrl, Long prix, List<Product> products, double quantity) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.prix = prix;
		this.products = products;
		this.quantity = quantity;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

}
