package com.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cart.dao.CustomerDAO;
import com.cart.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerRepo;
	
	public ResponseEntity<Customer> addCustomer(Customer customer){
		Customer x = customerRepo.save(customer);
		return new ResponseEntity<Customer>(x,HttpStatus.CREATED); 
		
	}
	
	public ResponseEntity<Customer> check(Customer customer){
		Customer x = customerRepo.findByMail(customer.getMail()).orElse(null);
		if(x==null) {
			return null;
		}
		
		if(!x.getPassword().equals(customer.getPassword())) {
			return null;
		}
		return new ResponseEntity<Customer>(x,HttpStatus.CREATED); 
	}
	
}
