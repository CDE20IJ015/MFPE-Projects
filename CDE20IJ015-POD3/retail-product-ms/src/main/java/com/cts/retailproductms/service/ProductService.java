package com.cts.retailproductms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.retailproductms.dao.ProductDao;
import com.cts.retailproductms.exception.ProductNotFoundException;
import com.cts.retailproductms.model.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public Optional<Product> searchProductById(long id){
		log.info("Searching product with the help of id");
		return productDao.findById(id);
	}

	public List<Product> searchProductByName(String name) {
		log.info("Searching product with the help of name");
		return productDao.findByNameIgnoreCaseContaining(name);
	}
	
	public Product addProductRating(long id,float rating) throws ProductNotFoundException {
		log.info("Searching product with the help of id");
		Optional<Product> product = productDao.findById(id);
		if(product.isEmpty()) {
			log.info("No product found with this id {}",id);
			throw new ProductNotFoundException("No product found with product id "+id);
		}
		log.info("Calculating the average rating and saving to the database");
		Product pr = product.get();
		float avgRat = pr.getRating();
		int count = pr.getCount();
		float finalRat = (avgRat*count+rating)/(count + 1);
		pr.setCount(count+1);
		pr.setRating(finalRat);
		return productDao.save(pr);
	}
	
	public List<Product> getAllProducts(){
		return productDao.findAll();
	}
}
