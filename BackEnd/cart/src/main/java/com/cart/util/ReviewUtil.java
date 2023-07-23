package com.cart.util;

public class ReviewUtil {
	private Long customer;
	private Long product;
	private String comment;
	private int ratting;
	
	public ReviewUtil() {}

	public ReviewUtil(Long customer, Long product, String comment, int ratting) {
		super();
		this.customer = customer;
		this.product = product;
		this.comment = comment;
		this.ratting = ratting;
	}

	public Long getCustomer() {
		return customer;
	}

	public void setCustomer(Long customer) {
		this.customer = customer;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRatting() {
		return ratting;
	}

	public void setRatting(int ratting) {
		this.ratting = ratting;
	}
	
	
	
}
