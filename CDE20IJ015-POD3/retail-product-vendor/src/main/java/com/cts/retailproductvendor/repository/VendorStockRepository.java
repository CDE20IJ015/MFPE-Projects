package com.cts.retailproductvendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.retailproductvendor.model.VendorStock;

import feign.Param;

@Repository
public interface VendorStockRepository extends JpaRepository<VendorStock, Integer> {
	
	@Query("SELECT vendorId FROM VendorStock WHERE stockInHand>=(:quantity) AND productId=(:productId)")
	List<Integer> getStock(@Param("productId") int productId, @Param("quantity") int quantity);
}
