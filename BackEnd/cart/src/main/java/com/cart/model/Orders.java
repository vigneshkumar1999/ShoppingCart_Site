package com.cart.model;

import javax.persistence.*;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name= "customer_id", referencedColumnName="id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name= "product_id", referencedColumnName="id")
	private Product product;
	
	private int count;
	
	@ManyToOne
	@JoinColumn(name= "address_id", referencedColumnName="id")
	private Address address;
	
	public Orders() {}

	public Orders(Long id, Customer customer, Product product, int count, Address address) {
		super();
		this.id = id;
		this.customer = customer;
		this.product = product;
		this.count = count;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}