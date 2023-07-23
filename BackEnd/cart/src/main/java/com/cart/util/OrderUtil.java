package com.cart.util;


public class OrderUtil {
	private Long customer;
	private Long product;
	private int count;
	Long address;
	
	public OrderUtil() {}

	public OrderUtil(Long customer, Long product, int count,Long address) {
		super();
		this.customer = customer;
		this.product = product;
		this.count = count;
		this.address=address;
	}
	

	public Long getAddress() {
		return address;
	}

	public void setAddress(Long address) {
		this.address = address;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

}
