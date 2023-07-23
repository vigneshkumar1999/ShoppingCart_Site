package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cart.dao.AddressDAO;
import com.cart.dao.CustomerDAO;
import com.cart.dao.OrderDAO;
import com.cart.dao.ProductDAO;
import com.cart.model.Address;
import com.cart.model.Orders;
import com.cart.model.Customer;
import com.cart.model.Product;
import com.cart.util.OrderUtil;


@Service
public class OrderService {
	
	@Autowired
	private OrderDAO orderRepo;
	
	@Autowired
	private ProductDAO productRepo;
	
	@Autowired
	private CustomerDAO customerRepo;
	
	@Autowired
	private AddressDAO addressRepo;
	
	public ResponseEntity<Orders> addOrder(OrderUtil util){
		Customer customer = customerRepo.findById(util.getCustomer()).orElse(null);
		Product product = productRepo.findById(util.getProduct()).orElse(null);
		Address address = addressRepo.findById(util.getAddress()).orElse(null);
		if(customer==null || product==null || address==null) {
			return null;
		}
		Orders order = new Orders();
		order.setCustomer(customer);
		order.setProduct(product);
		order.setCount(util.getCount());
		order.setAddress(address);
		Orders saved = orderRepo.save(order);
		return new ResponseEntity<Orders>(saved,HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<List<Orders>> findByCustomerId(Long id){
		return new ResponseEntity<List<Orders>>(orderRepo.findByCustomerId(id),HttpStatus.OK);
	}
}
