package com.sensors.entities;

public class Message {

	private String error;
	private String success;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Message(String error, String success) {
		super();
		this.error = error;
		this.success = success;
	}

}
