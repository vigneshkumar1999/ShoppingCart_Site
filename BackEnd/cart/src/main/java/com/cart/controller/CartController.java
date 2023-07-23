package com.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.Cart;
import com.cart.service.CartService;
import com.cart.util.CartUtil;

@CrossOrigin
@RestController
@RequestMapping("/api/v2/")
public class CartController {
	@Autowired
	private CartService service;
	
	@PostMapping("/cart")
	public ResponseEntity<Cart> addCart(@RequestBody CartUtil util){
		return service.addCart(util);
	}
	
	@DeleteMapping("/cart/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id){
		return service.delete(id);
	}
	
	@GetMapping("/cart/{id}")
	public ResponseEntity<List<Cart>> getAllByCustomerId(@PathVariable Long id){
		return service.getAllByCustomerId(id);
	}
	@PutMapping("/cart-{id}/{count}")
	public ResponseEntity<Cart> update(@PathVariable Long id, @PathVariable int count){
		return service.update(id,count);
	}
	
	
}
