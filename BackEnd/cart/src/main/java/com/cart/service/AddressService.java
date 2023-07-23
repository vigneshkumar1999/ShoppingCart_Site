package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cart.dao.AddressDAO;
import com.cart.dao.CustomerDAO;
import com.cart.model.Address;
import com.cart.model.Customer;
import com.cart.util.AddressUtil;

@Service
public class AddressService {
	
	@Autowired
	private AddressDAO addressRepo;
	
	@Autowired
	private CustomerDAO customerRepo;
	
	
	public ResponseEntity<Address> addAddress(AddressUtil util){
		Customer customer = customerRepo.findById(util.getCustomer()).orElse(null);
		if(customer==null) {
			return null;
		}
		Address address = new Address();
		address.setCustomer(customer);
		address.setName(util.getName());
		address.setAddress(util.getAddress());
		address.setNumber(util.getNumber());
		Address saved = addressRepo.save(address);
		return new ResponseEntity<Address>(saved,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Boolean> delete(Long id){
		Address address = addressRepo.findById(id).orElse(null);
		if(address==null)return null;
		addressRepo.delete(address);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<List<Address>> getAllByCustomerId(Long id){
		return new ResponseEntity<List<Address>>(addressRepo.findByCustomerId(id),HttpStatus.OK);
	}
}
