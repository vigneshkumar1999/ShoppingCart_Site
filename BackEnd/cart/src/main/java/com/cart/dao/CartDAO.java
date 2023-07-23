package com.cart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.model.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart, Long>{
	List<Cart> findByCustomerId(Long id);
}