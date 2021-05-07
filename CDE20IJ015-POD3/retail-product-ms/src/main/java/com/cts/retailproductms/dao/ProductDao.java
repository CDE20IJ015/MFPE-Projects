package com.cts.retailproductms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.retailproductms.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{

	List<Product> findByNameIgnoreCaseContaining(String name);
}
