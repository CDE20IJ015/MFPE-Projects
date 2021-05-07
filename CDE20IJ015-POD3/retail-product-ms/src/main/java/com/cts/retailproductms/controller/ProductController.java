package com.cts.retailproductms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.retailproductms.exception.InternalServerErrorException;
import com.cts.retailproductms.exception.ProductNotFoundException;
import com.cts.retailproductms.exception.UnauthorisedAccessException;
import com.cts.retailproductms.feign.AuthFeign;
import com.cts.retailproductms.model.Product;
import com.cts.retailproductms.service.ProductService;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	AuthFeign authFeign;

	@GetMapping("/searchProductById/{id}")
	public ResponseEntity<Product> searchProductById(@RequestHeader("Authorization") String token, @PathVariable long id) throws ProductNotFoundException, UnauthorisedAccessException, InternalServerErrorException{
		log.info("Searching product with id");
		try {
			authFeign.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new UnauthorisedAccessException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		Optional<Product> product = productService.searchProductById(id);
		if(product.isEmpty()) {
			log.info("No product found with the id {}",id);
			throw new ProductNotFoundException("No product with product id "+id+" is present");
		}
		return new ResponseEntity<Product>(product.get(),HttpStatus.OK);
		
	}
	
	@GetMapping("/searchProductByName/{name}")
	public ResponseEntity<?> searchProductByName(@RequestHeader("Authorization") String token,@PathVariable String name) throws ProductNotFoundException, UnauthorisedAccessException, InternalServerErrorException{
		try {
			authFeign.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new UnauthorisedAccessException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		List<Product> product = productService.searchProductByName(name);
		if(product.isEmpty()) {
			log.info("No product Found with the name {}",name);
			throw new ProductNotFoundException("No product with name "+name+" is present");
		}
		return ResponseEntity.status(HttpStatus.OK).body(product);
		
	}
	
	@PostMapping("/addProductRating/{id}/{rating}")
	public ResponseEntity<?> addProductRating(@RequestHeader("Authorization") String token,@PathVariable long id,@PathVariable float rating) throws ProductNotFoundException, UnauthorisedAccessException, InternalServerErrorException{
		try {
			authFeign.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new UnauthorisedAccessException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		Product product = productService.addProductRating(id, rating);
		if(product != null) {
			log.info("Rating submitted Succesfully");
			return ResponseEntity.status(HttpStatus.OK).body("Rating submitted successfully");
		}
		else {
			log.info("Not able to submit rating");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to add the rating");
		}
	}
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<?> getAllProduct(@RequestHeader("Authorization") String token) throws ProductNotFoundException, UnauthorisedAccessException, InternalServerErrorException{
		log.info("Getting allProducts available");
		try {
			authFeign.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new UnauthorisedAccessException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		List<Product> product = productService.getAllProducts();
		if(product.isEmpty()) {
			throw new ProductNotFoundException("No products found");
		}
			
		return ResponseEntity.status(HttpStatus.OK).body(product);
		
	}
}
