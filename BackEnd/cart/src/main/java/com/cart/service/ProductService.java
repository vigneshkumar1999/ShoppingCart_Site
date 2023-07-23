package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cart.dao.ProductDAO;
import com.cart.dao.ReviewDAO;
import com.cart.model.Product;
import com.cart.util.ProductUtil;


@Service
public class ProductService {
	@Autowired
	private ProductDAO productRepo;
	
	@Autowired
	private ReviewDAO reviewRepo;
	
	public ResponseEntity<List<Product>> getAll(){
		return new ResponseEntity<List<Product>>(productRepo.findAll(),HttpStatus.OK);
	}
	
	public ResponseEntity<ProductUtil> findByProductId(Long id){
		Product product = productRepo.findById(id).orElse(null);
		ProductUtil util = new ProductUtil();
		util.setId(id);
		util.setName(product.getName());
		util.setUrl(product.getImage());
		util.setPrice(product.getPrice());
		util.setRatting(product.getRatting());
		util.setReviews(reviewRepo.findByProductId(id));
		return new ResponseEntity<ProductUtil>(util,HttpStatus.OK);
	}
	
	public ResponseEntity<Product> updateRatting(Long id, int ratting){
		Product product = productRepo.findById(id).orElse(null);
		if(product.getCount()==0) {
			product.setRatting(ratting);
			product.setCount((long)1);
		}else {
			double num = product.getRatting()*product.getCount() + ratting;
			product.setCount(product.getCount()+1);
			num/=product.getCount();
			product.setRatting(num);
		}
		Product saved = productRepo.save(product);
		return new ResponseEntity<Product>(saved,HttpStatus.OK);
		
	}

	public ResponseEntity<Product> addProduct(Product product){
		Product saved = productRepo.save(product);
		return new ResponseEntity<Product>(saved,HttpStatus.OK);
	}
	
	
}
