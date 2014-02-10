package com.asm.hibernate.domain;

import java.util.Date;

public class IdCard {
	private int id;
	private Date validity;
	private User person;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getValidity() {
		return validity;
	}
	public void setValidity(Date validity) {
		this.validity = validity;
	}
	public User getPerson() {
		return person;
	}
	public void setPerson(User person) {
		this.person = person;
	}	
} 
