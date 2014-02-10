package com.asm.hibernate.domain;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private Date date;
	private IdCard idCard;
	private int version1;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	public int getVersion1() {
		return version1;
	}

	public void setVersion1(int version) {
		this.version1 = version;
	}
}
