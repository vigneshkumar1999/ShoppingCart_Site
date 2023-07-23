package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.Customer;
import com.cart.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/api/v2/")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCart(@RequestBody Customer customer){
		return service.addCustomer(customer);
	}
	@PutMapping("/customer/check")
	public ResponseEntity<Customer> check(@RequestBody Customer customer){
		
		return service.check(customer);
	}
}
