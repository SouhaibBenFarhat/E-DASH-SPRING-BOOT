package com.sensors.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String login;
	private String email;
	private String password;
	private String provider;
	private String profileId;
	private String profilePicture;
	private String firstName;
	private String lastName;
	private String linkUri;
	@OneToOne
	private Boitier boitier;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Device> devices;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String login, String email, String password, String provider, String profileId,
			String profilePicture, String firstName, String lastName, String linkUri, List<Device> devices, Boitier boitier) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.password = password;
		this.provider = provider;
		this.profileId = profileId;
		this.profilePicture = profilePicture;
		this.firstName = firstName;
		this.lastName = lastName;
		this.linkUri = linkUri;
		this.devices = devices;
		this.boitier = boitier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Device> getDevices() {
		return devices;
	}

	@JsonSetter
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLinkUri() {
		return linkUri;
	}

	public void setLinkUri(String linkUri) {
		this.linkUri = linkUri;
	}

	public Boitier getBoitier() {
		return boitier;
	}

	public void setBoitier(Boitier boitier) {
		this.boitier = boitier;
	}
	
	

}
