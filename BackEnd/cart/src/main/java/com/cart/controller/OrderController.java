package com.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.Orders;
import com.cart.service.OrderService;
import com.cart.util.OrderUtil;


@CrossOrigin
@RestController
@RequestMapping("/api/v2/")
public class OrderController {
	@Autowired
	private OrderService service;
	
	
	@PostMapping("/order")
	public ResponseEntity<Orders> addOrder(@RequestBody OrderUtil util){
		return service.addOrder(util);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<List<Orders>> findByCustomerId(@PathVariable Long id){
		return service.findByCustomerId(id);
	}
	
	
	
	
}
