package com.cart.util;

public class CartUtil {
	public Long id;
	private Long customer;
	private Long product;
	private int count;
	
	public CartUtil() {}

	public CartUtil(Long customer, Long product, int count,Long id) {
		super();
		this.id=id;
		this.customer = customer;
		this.product = product;
		this.count = count;
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
