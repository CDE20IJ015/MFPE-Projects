package com.cts.retailproducteCommerceportal.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.retailproducteCommerceportal.exception.ProductNotFoundException;
import com.cts.retailproducteCommerceportal.exception.UnauthorisedAccessException;
import com.cts.retailproducteCommerceportal.model.Product;
@FeignClient(name = "productclient", url = "${feign.url.product-ms}/", fallback = ProductClientFallback.class)
public interface ProductClient {

	@GetMapping("searchProductById/{id}")
	public List<Product> searchProductById(@RequestHeader("Authorization") String token, @PathVariable long id);
	
	@GetMapping("searchProductByName/{name}")
	public List<Product> searchProductByName(@RequestHeader("Authorization") String token, @PathVariable String name);

	@PostMapping("addProductRating/{id}/{rating}")
	public ResponseEntity<String> addProductRating(@RequestHeader("Authorization") String token, @PathVariable long id, @PathVariable float rating);
	
	@GetMapping(value = "getAllProduct")
	public List<Product> getProducts(@RequestHeader("Authorization") String token);
}
