package com.cts.retailproductproceedToBuyservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.retailproductproceedToBuyservice.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	public Cart findByUserIdAndProductId(long userId, int productId);
	public List<Cart> findByUserId(long userId);
}
