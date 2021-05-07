package com.cts.retailproductproceedToBuyservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.retailproductproceedToBuyservice.model.VendorWishlist;

@Repository
public interface WishlistRepository extends JpaRepository<VendorWishlist, Integer>{

	public List<VendorWishlist> findByCustomerId(long customerId);
	public VendorWishlist findByCustomerIdAndProductId(long customerId, int productId);

}
