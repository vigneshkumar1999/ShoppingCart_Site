package com.cart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.model.Address;

@Repository
public interface AddressDAO extends JpaRepository<Address, Long>{
	List<Address> findByCustomerId(Long id);
}
