package com.cart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.model.Orders;

@Repository
public interface OrderDAO extends JpaRepository<Orders, Long>{
	List<Orders> findByCustomerId(Long id);
}
