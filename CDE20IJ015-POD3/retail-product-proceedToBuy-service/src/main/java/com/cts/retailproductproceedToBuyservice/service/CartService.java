package com.cts.retailproductproceedToBuyservice.service;

import java.util.Date;
import java.util.List;

import com.cts.retailproductproceedToBuyservice.DTO.CartRequest;
import com.cts.retailproductproceedToBuyservice.DTO.Product;
import com.cts.retailproductproceedToBuyservice.DTO.Vendor;
import com.cts.retailproductproceedToBuyservice.exception.ProductNotFoundException;

public interface CartService {

	public void addProductToWishlist(long customerId, int productId, int quantity);

	public void deleteFromCart(long customerId, int productId) throws ProductNotFoundException;

	public void deleteFromWishlist(long customerId, int productId) throws ProductNotFoundException;

	public List<Product> getWishlist(String token, long customerId);

	public List<CartRequest> getCart(String token, long customerId);

	public void updateCart(long customerId, int productId, int qty);

	void addProductToCart(String token, long customerId, int productId, int zipCode, Date expectedDeliveryDate, int quantity) throws ProductNotFoundException;

	public double getDeliveryCharge(String token,long customerId);

	public float calculateTotalForCart(String token, long customerId);

	void updateVendor(String token, long customerId, int productId, int qty, int vendorId);

	public List<Vendor> getVendors(String string, int i, int j);

}
