package com.cart.util;
import java.util.*;

import com.cart.model.Review;
public class ProductUtil {
	private Long id;
	private String name;
	private String url;
	private int price;
	private List<Review> reviews;
	private double ratting;
	
	public ProductUtil() {}

	public ProductUtil(Long id, String name, String url, int price, List<Review> reviews, double ratting) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.price = price;
		this.reviews = reviews;
		this.ratting=ratting;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public double getRatting() {
		return ratting;
	}

	public void setRatting(double ratting) {
		this.ratting = ratting;
	}
	
	
	
	
	
	

}
