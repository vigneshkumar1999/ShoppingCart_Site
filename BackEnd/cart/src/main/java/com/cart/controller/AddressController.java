package com.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.Address;
import com.cart.service.AddressService;
import com.cart.util.AddressUtil;

@CrossOrigin
@RestController
@RequestMapping("/api/v2/")
public class AddressController {
	@Autowired
	private AddressService service;
	
	@PostMapping("/address")
	public ResponseEntity<Address> addAddress(@RequestBody AddressUtil util){
		return service.addAddress(util);
	}
	
	@DeleteMapping("/address/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id){
		return service.delete(id);
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<List<Address>> getAllByCustomerId(@PathVariable Long id){
		
		return service.getAllByCustomerId(id);
	}
	
	
}

