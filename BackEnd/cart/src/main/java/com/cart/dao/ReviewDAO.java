package com.cart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.model.Review;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Long>{
	List<Review> findByProductId(Long id);
}