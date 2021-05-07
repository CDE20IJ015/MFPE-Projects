package com.cts.retailproducteCommerceportal.client;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cts.retailproducteCommerceportal.exception.CartNotFoundException;
import com.cts.retailproducteCommerceportal.exception.ProductNotFoundException;
import com.cts.retailproducteCommerceportal.exception.UnauthorisedAccessException;
import com.cts.retailproducteCommerceportal.exception.WishlistNotFoundException;
import com.cts.retailproducteCommerceportal.model.CartRequest;
import com.cts.retailproducteCommerceportal.model.Product;

public class ProceedClientFallback implements ProceedClient {

	@Override
	public List<Product> getWishlist(String token) throws WishlistNotFoundException, UnauthorisedAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getCart(String token) throws CartNotFoundException, UnauthorisedAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> deleteProductFromCart(String token, int productId)
			throws ProductNotFoundException, UnauthorisedAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> updateCart(String token, int productId, int qty) throws UnauthorisedAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> addProductToCart(String token, int productId, String expectedDeliveryDate)
			throws ParseException, ProductNotFoundException, UnauthorisedAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> updateVendor(String token, int productId, int qty, int vendorId)
			throws UnauthorisedAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Double> getDeliveryCharge(String token) throws UnauthorisedAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Float> calculateTotalForCart(String token) throws UnauthorisedAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
