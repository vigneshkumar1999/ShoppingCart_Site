package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cart.dao.CartDAO;
import com.cart.dao.CustomerDAO;
import com.cart.dao.ProductDAO;
import com.cart.model.Cart;
import com.cart.model.Customer;
import com.cart.model.Product;
import com.cart.util.CartUtil;

@Service
public class CartService {
	
	@Autowired
	private CartDAO cartRepo;
	
	@Autowired
	private ProductDAO productRepo;
	
	@Autowired
	private CustomerDAO customerRepo;
	
	public ResponseEntity<Cart> addCart(CartUtil util){
		Customer customer = customerRepo.findById(util.getCustomer()).orElse(null);
		Product product = productRepo.findById(util.getProduct()).orElse(null);
		if(customer==null || product==null) {
			return null;
		}
		Cart cart = new Cart();
		cart.setCustomer(customer);
		cart.setProduct(product);
		cart.setCount(util.getCount());
		Cart saved = cartRepo.save(cart);
		return new ResponseEntity<Cart>(saved,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Boolean> delete(Long id){
		Cart cart = cartRepo.findById(id).orElse(null);
		if(cart==null)return null;
		cartRepo.delete(cart);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<List<Cart>> getAllByCustomerId(Long id){
		return new ResponseEntity<List<Cart>>(cartRepo.findByCustomerId(id),HttpStatus.OK);
	}
	
	public ResponseEntity<Cart> update(Long id, int count){
		Cart cart = cartRepo.findById(id).orElse(null);
		if(cart==null)return null;
		
		cart.setCount(count);
		Cart saved = cartRepo.save(cart);
		return new ResponseEntity<Cart>(saved,HttpStatus.CREATED);
		
	}
	
	
	
}
