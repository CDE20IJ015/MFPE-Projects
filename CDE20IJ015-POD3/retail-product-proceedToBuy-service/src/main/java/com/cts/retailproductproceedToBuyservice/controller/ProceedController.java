package com.cts.retailproductproceedToBuyservice.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.retailproductproceedToBuyservice.DTO.CartRequest;
import com.cts.retailproductproceedToBuyservice.DTO.Product;
import com.cts.retailproductproceedToBuyservice.client.AuthClient;
import com.cts.retailproductproceedToBuyservice.client.VendorClient;
import com.cts.retailproductproceedToBuyservice.exception.AccessUnauthorizedException;
import com.cts.retailproductproceedToBuyservice.exception.CartNotFoundException;
import com.cts.retailproductproceedToBuyservice.exception.InternalServerErrorException;
import com.cts.retailproductproceedToBuyservice.exception.ProductNotFoundException;
import com.cts.retailproductproceedToBuyservice.exception.WishlistNotFoundException;
import com.cts.retailproductproceedToBuyservice.service.CartService;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProceedController {
	
	@Autowired
	private CartService service;
	@Autowired
	private AuthClient authClient;
	@Autowired
	VendorClient vendorClient;

	/*
	 * @PostMapping(
	 * "/addProductToCart/{customerId}/{productId}/{zipCode}/{expectedDeliveryDate}")
	 * public ResponseEntity<?> addProductToCart(@RequestHeader("Authorization")
	 * String token,
	 * 
	 * @PathVariable int customerId, @PathVariable int productId, @PathVariable int
	 * zipCode,
	 * 
	 * @PathVariable String expectedDeliveryDate) throws ParseException,
	 * ProductNotFoundException, AccessUnauthorizedException {
	 * 
	 * if (authClient.getValidity(token) == false) { throw new
	 * AccessUnauthorizedException("Invalid token"); } int
	 * vendorId=vendorClient.getVendors(token,productId, 1).get(0).getVendorId();
	 * service.addProductToCart(token,customerId, productId, zipCode, new
	 * SimpleDateFormat("dd-MM-yyyy").parse(expectedDeliveryDate), vendorId,1);
	 * return new ResponseEntity<String>("Added to cart.", HttpStatus.CREATED); }
	 */
	
	@PostMapping("/addProductToCart/{productId}/{expectedDeliveryDate}")
	public ResponseEntity<?> addProductToCart(@RequestHeader("Authorization") String token,
			@PathVariable int productId,@PathVariable String expectedDeliveryDate)
			throws ParseException, ProductNotFoundException, AccessUnauthorizedException, InternalServerErrorException {
		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		long customerId = authClient.getId(token);
		int zipCode = authClient.getZip(token);
		log.info(expectedDeliveryDate);
		// int vendorId=vendorClient.getVendors(productId, 1).get(0).getVendorId();
		service.addProductToCart(token, customerId, productId, zipCode,
				new SimpleDateFormat("dd-MM-yyyy").parse(expectedDeliveryDate), 1);
		return new ResponseEntity<String>("Added successfully.", HttpStatus.CREATED);
	}

	@GetMapping("/getCart")
	public ResponseEntity<?> getCart(@RequestHeader("Authorization") String token)
			throws CartNotFoundException, AccessUnauthorizedException, InternalServerErrorException {

		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		long customerId = authClient.getId(token);
		List<CartRequest> list = service.getCart(token, customerId);
		if (list.isEmpty()) {
			log.info("Cart is Empty");
			throw new CartNotFoundException("Cart for user:=" + customerId + " was not found.");
		}
		return new ResponseEntity<List<CartRequest>>(list, HttpStatus.OK);
	}

	@GetMapping("/getWishlist")
	public ResponseEntity<?> getWishlist(@RequestHeader("Authorization") String token)
			throws WishlistNotFoundException, AccessUnauthorizedException, InternalServerErrorException {

		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		long customerId = authClient.getId(token);
		List<Product> list = service.getWishlist(token, customerId);
		if (list.isEmpty())
			throw new WishlistNotFoundException("Wishlist for user:=" + customerId + " was not found.");
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

	@DeleteMapping("/deleteProductFromCart/{productId}")
	public ResponseEntity<?> deleteProductFromCart(@RequestHeader("Authorization") String token, @PathVariable int productId)
			throws ProductNotFoundException, AccessUnauthorizedException, InternalServerErrorException {

		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		long customerId = authClient.getId(token);
		service.deleteFromCart(customerId, productId);
		return new ResponseEntity<String>("Product with id " + productId + "removed successfully", HttpStatus.OK);
	}

	@PutMapping("/updateCart/{productId}/{qty}")
	public ResponseEntity<?> updateCart(@RequestHeader("Authorization") String token,
			@PathVariable int productId, @PathVariable int qty) throws AccessUnauthorizedException, InternalServerErrorException {
		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		long customerId = authClient.getId(token);
		service.updateCart(customerId, productId, qty);
		return new ResponseEntity<String>("Cart updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/deleteProductFromWishlist/{productId}")
	public ResponseEntity<?> deleteProductFromWishlist(@RequestHeader("Authorization") String token,@PathVariable int productId)
			throws ProductNotFoundException, AccessUnauthorizedException, InternalServerErrorException {

		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		long customerId = authClient.getId(token);
		service.deleteFromWishlist(customerId, productId);
		return new ResponseEntity<String>("Product with id " + productId + "removed successfully", HttpStatus.OK);
	}

	@PostMapping("/addProductToWishlist/{productId}/{quantity}")
	public ResponseEntity<?> addProductToWishList(@RequestHeader("Authorization") String token,
			@PathVariable int productId, @PathVariable int quantity)
			throws AccessUnauthorizedException, InternalServerErrorException {

		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		long customerId = authClient.getId(token);
		service.addProductToWishlist(customerId, productId, quantity);
		return new ResponseEntity<String>("Added to wishlist.", HttpStatus.CREATED);
	}

	@GetMapping("/test")
	public String test() {
		return "OK";
	}

	@PutMapping("/updateVendor/{productId}/{qty}/{vendorId}")
	public ResponseEntity<?> updateVendor(@RequestHeader("Authorization") String token,
			@PathVariable int productId, @PathVariable int qty, @PathVariable int vendorId)
			throws AccessUnauthorizedException, InternalServerErrorException {
		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		long customerId = authClient.getId(token);
		service.updateVendor(token, customerId, productId, qty, vendorId);
		return new ResponseEntity<String>("Vendor updated successfully", HttpStatus.OK);
	}

	// to get the vendor charge
	@PostMapping("/charge")
	public ResponseEntity<?> getDeliveryCharge(@RequestHeader("Authorization") String token) throws AccessUnauthorizedException, InternalServerErrorException {
		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		long customerId = authClient.getId(token);
		return ResponseEntity.status(HttpStatus.OK).body(service.getDeliveryCharge(token, customerId));
	}

	// calculate total cart amount except delivery charge
	@GetMapping("/total")
	public ResponseEntity<?> calculateTotalForCart(@RequestHeader("Authorization") String token) throws AccessUnauthorizedException, InternalServerErrorException {
		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		long customerId = authClient.getId(token);
		return ResponseEntity.status(HttpStatus.OK).body(service.calculateTotalForCart(token, customerId));
	}
}

