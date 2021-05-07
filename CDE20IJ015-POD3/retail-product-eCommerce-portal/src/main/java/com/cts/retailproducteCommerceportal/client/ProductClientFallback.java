package com.cts.retailproducteCommerceportal.client;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cts.retailproducteCommerceportal.exception.ProductNotFoundException;
import com.cts.retailproducteCommerceportal.exception.UnauthorisedAccessException;
import com.cts.retailproducteCommerceportal.model.Product;

public class ProductClientFallback implements ProductClient {

	@Override
	public List<Product> searchProductById(String token, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProductByName(String token, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> addProductRating(String token, long id, float rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducts(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
