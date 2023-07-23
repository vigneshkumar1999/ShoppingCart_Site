package com.cart.model;

import javax.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String mail;
	
	private String password;
	
	public Customer() {}

	public Customer(Long id, String name, String mail, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.password=password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mail=" + mail + ", password=" + password + "]";
	}
	
	
	
	
}
