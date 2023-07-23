package com.cart.util;

public class AddressUtil {
	private Long customer;
	private String name;
	private String number;
	private String address;
	
	public AddressUtil() {}

	public AddressUtil(Long customer, String name, String number, String address) {
		super();
		this.customer = customer;
		this.name = name;
		this.number = number;
		this.address = address;
	}

	public Long getCustomer() {
		return customer;
	}

	public void setCustomer(Long customer) {
		this.customer = customer;
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
	
	

}
