package com.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.model.Product;


@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{

}