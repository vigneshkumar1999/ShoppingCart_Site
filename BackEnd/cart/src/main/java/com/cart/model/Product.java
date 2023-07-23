package com.cart.model;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long count=(long)0;
	
	private String name;
	
	private String image;
	
	private String description;
	
	private int price;
	
	private double ratting=0;
	
	public Product() {}

	public Product(Long id, String name, String image, int price, double ratting, String description, Long count) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.ratting = ratting;
		this.description=description;
		this.count=count;
	}
	
	

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getRatting() {
		return ratting;
	}

	public void setRatting(double ratting) {
		this.ratting = ratting;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
	
}
