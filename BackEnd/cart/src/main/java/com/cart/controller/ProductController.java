package com.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cart.model.Product;
import com.cart.service.ProductService;
import com.cart.util.ProductUtil;

@CrossOrigin
@RestController
@RequestMapping("/api/v2/")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductUtil> findById(@PathVariable Long id){
		return service.findByProductId(id);
	}
	
	@PutMapping("/product/{id}/ratting={ratting}")
	public ResponseEntity<Product> updateRatting(@PathVariable Long id, @PathVariable int ratting){
		return service.updateRatting(id,ratting);
	}

	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		System.out.println("PLL");
		return service.addProduct(product);
	}
}
