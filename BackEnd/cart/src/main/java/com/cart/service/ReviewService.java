package com.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cart.dao.CustomerDAO;
import com.cart.dao.ProductDAO;
import com.cart.dao.ReviewDAO;
import com.cart.util.ReviewUtil;
import com.cart.model.Customer;
import com.cart.model.Product;
import com.cart.model.Review;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewDAO reviewRepo;
	
	@Autowired
	private ProductDAO productRepo;
	
	@Autowired
	private CustomerDAO customerRepo;
	
	public ResponseEntity<Review> addReview(ReviewUtil util){
		Customer customer = customerRepo.findById(util.getCustomer()).orElse(null);
		
		Product product = productRepo.findById(util.getProduct()).orElse(null);
		if(customer==null || product==null) {
			return null;
		}
		
		Review review = new Review();
		review.setCustomer(customer);
		review.setProduct(product);
		review.setComment(util.getComment());
		review.setRatting(util.getRatting());
		Review saved = reviewRepo.save(review);
		return new ResponseEntity<Review>(saved,HttpStatus.CREATED);
	}
	
	
}
