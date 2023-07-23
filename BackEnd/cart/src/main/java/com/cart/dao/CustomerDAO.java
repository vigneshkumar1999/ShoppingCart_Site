package com.cart.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>{
	Optional<Customer> findByMail(String mail);
}