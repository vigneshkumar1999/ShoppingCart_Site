package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.Review;
import com.cart.service.ReviewService;
import com.cart.util.ReviewUtil;

@CrossOrigin
@RestController
@RequestMapping("/api/v2/")
public class ReviewController {
	@Autowired
	private ReviewService service;
	
	@PostMapping("/review")
	public ResponseEntity<Review> addReview(@RequestBody ReviewUtil util){
		return service.addReview(util);
	}
}
