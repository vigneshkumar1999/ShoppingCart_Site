package com.cart.model;



import javax.persistence.*;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String number;
	
	private String address;
	
	
	@ManyToOne
	@JoinColumn(name= "customer_id", referencedColumnName="id")
	private Customer customer;
	
	public Address() {}

	public Address(Long id, String name, String number, String address, Customer customer) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.address = address;
		this.customer = customer;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
