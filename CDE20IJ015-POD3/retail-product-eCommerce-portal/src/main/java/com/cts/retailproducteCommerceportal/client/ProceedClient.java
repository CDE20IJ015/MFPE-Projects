package com.cts.retailproducteCommerceportal.client;

import java.text.ParseException;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.retailproducteCommerceportal.exception.CartNotFoundException;
import com.cts.retailproducteCommerceportal.exception.ProductNotFoundException;
import com.cts.retailproducteCommerceportal.exception.UnauthorisedAccessException;
import com.cts.retailproducteCommerceportal.exception.WishlistNotFoundException;
import com.cts.retailproducteCommerceportal.model.CartRequest;
import com.cts.retailproducteCommerceportal.model.Product;

@FeignClient(name = "prceedclient", url = "${feign.url.proceedToBuy-ms}/", fallback = ProceedClientFallback.class)
public interface ProceedClient {

	@GetMapping("getWishlist")
	public List<Product> getWishlist(@RequestHeader("Authorization") String token)
			throws WishlistNotFoundException, UnauthorisedAccessException;
	
	@GetMapping("/getCart")
	public ResponseEntity<?> getCart(@RequestHeader("Authorization") String token)
			throws CartNotFoundException, UnauthorisedAccessException;
	
	@DeleteMapping("/deleteProductFromCart/{productId}")
	public ResponseEntity<String> deleteProductFromCart(@RequestHeader("Authorization") String token, @PathVariable int productId)
			throws ProductNotFoundException, UnauthorisedAccessException;
	
	@PutMapping("/updateCart/{productId}/{qty}")
	public ResponseEntity<String> updateCart(@RequestHeader("Authorization") String token,
			@PathVariable int productId, @PathVariable int qty) throws UnauthorisedAccessException;
	
	@PostMapping("/addProductToCart/{productId}/{expectedDeliveryDate}")
	public ResponseEntity<String> addProductToCart(@RequestHeader("Authorization") String token,
			@PathVariable int productId,@PathVariable String expectedDeliveryDate)
			throws ParseException, ProductNotFoundException, UnauthorisedAccessException;
	
	@PutMapping("/updateVendor/{productId}/{qty}/{vendorId}")
	public ResponseEntity<String> updateVendor(@RequestHeader("Authorization") String token,
			@PathVariable("productId") int productId, @PathVariable("qty") int qty, @PathVariable("vendorId") int vendorId)
			throws UnauthorisedAccessException;
	
	@PostMapping("/charge")
	public ResponseEntity<Double> getDeliveryCharge(@RequestHeader("Authorization") String token) throws UnauthorisedAccessException;
	
	@GetMapping("/total")
	public ResponseEntity<Float> calculateTotalForCart(@RequestHeader("Authorization") String token) throws UnauthorisedAccessException;
}
