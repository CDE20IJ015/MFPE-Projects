package com.cts.retailproductproceedToBuyservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.retailproductproceedToBuyservice.DTO.CartRequest;
import com.cts.retailproductproceedToBuyservice.DTO.Product;
import com.cts.retailproductproceedToBuyservice.DTO.Vendor;
import com.cts.retailproductproceedToBuyservice.client.AuthClient;
import com.cts.retailproductproceedToBuyservice.client.ProductClient;
import com.cts.retailproductproceedToBuyservice.client.VendorClient;
import com.cts.retailproductproceedToBuyservice.exception.ProductNotFoundException;
import com.cts.retailproductproceedToBuyservice.model.Cart;
import com.cts.retailproductproceedToBuyservice.model.VendorWishlist;
import com.cts.retailproductproceedToBuyservice.repository.CartRepository;
import com.cts.retailproductproceedToBuyservice.repository.WishlistRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository repository;
	@Autowired
	ProductClient client;
	@Autowired
	WishlistRepository wlrepo;
	@Autowired
	AuthClient auth;
	@Autowired
	VendorClient vclient;

	// @Transactional
	/*
	 * @Override public void addProductToCart(String token,int customerId, int
	 * productId, int zipCode, Date expectedDeliveryDate, int vendorId, int
	 * quantity) throws ProductNotFoundException { String test = client.test();
	 * log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + test);
	 * 
	 * ResponseEntity<Product> p = client.searchProductById(token,productId); if (p
	 * == null) { throw new ProductNotFoundException("Product with id=:" + productId
	 * + " was not found."); }
	 * 
	 * Cart c = repository.findByUserIdAndProductId(customerId,
	 * p.getBody().getId()); if (c != null) { c.setCount(c.getCount() + quantity);
	 * repository.save(c); // return ResponseEntity.status(HttpStatus.OK).body(); }
	 * else { Cart cr = new Cart(); cr.setUserId(customerId);
	 * cr.setProductId(productId); cr.setZipcode(zipCode); cr.setVendorId(vendorId);
	 * cr.setCount(quantity); cr.setDelivery_date(expectedDeliveryDate); // 6,
	 * customerId, p.getId(), zipCode, expectedDeliveryDate, 15, 1);
	 * repository.save(cr); // return
	 * ResponseEntity.status(HttpStatus.OK).body(repository.save(cr));
	 * 
	 * } }
	 */
	@Transactional
	@Override
	public void addProductToCart(String token, long customerId, int productId, int zipCode, Date expectedDeliveryDate,
			int quantity) throws ProductNotFoundException {
		// String test = client.test();
		// log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + test);
		log.info("token:{},productId:{},quantity:{}",token,productId,quantity);

		List<Vendor> vendorsAvail = vclient.getVendors(token, productId, 1);
		log.info("vendor list:{}",vendorsAvail);
		if (vendorsAvail.isEmpty()) {
			// deleteFromWishlist(customerId, productId);
			VendorWishlist vwl = wlrepo.findByCustomerIdAndProductId(customerId, productId);

			if (vwl != null) {
				wlrepo.delete(vwl);
			}
			addProductToWishlist(customerId, productId, quantity);
		} else {
			log.info("<--------Inside service of Adding product to cart for customer---------->");
			ResponseEntity<Product> p = client.searchProductById(token, productId);
			if (p == null) {
				throw new ProductNotFoundException("Product with id=:" + productId + " was not found.");
			}
			Cart c = repository.findByUserIdAndProductId(customerId, p.getBody().getId());
			if (c != null) {
				c.setQty(c.getQty() + quantity);
				c.setVendorId(vendorsAvail.get(0).getVendorId());
				repository.save(c);
				// return ResponseEntity.status(HttpStatus.OK).body();
			} else {
				Cart cr = new Cart();
				cr.setUserId(customerId);
				cr.setProductId(productId);
				cr.setZipcode(zipCode);
				cr.setVendorId(vendorsAvail.get(0).getVendorId());
				cr.setQty(quantity);
				cr.setDeliveryDate(expectedDeliveryDate);
				// 6, customerId, p.getId(), zipCode, expectedDeliveryDate, 15, 1);
				repository.save(cr);
				// return ResponseEntity.status(HttpStatus.OK).body(repository.save(cr));

			}
			log.info("<-------Product Added to cart---------(service method ends)");
		}
	}

	@Transactional
	@Override
	public void addProductToWishlist(long customerId, int productId, int quantity) {
		log.info("customerId:{},productId:{},quantity:{}",customerId,productId,quantity);
		VendorWishlist wl = new VendorWishlist();
		wl.setCustomerId(customerId);
		wl.setProductId(productId);
		wl.setQuantity(quantity);
		wl.setAddingDateToWishlist(LocalDate.now());
		wlrepo.save(wl);
		// return ResponseEntity.status(HttpStatus.OK).body(wlrepo.save(new
		// VendorWishlist(v.getVendorId(),productId,quantity,new Date())));
		log.info("<-------Product Add to wishlist---------(service method ends)");
	}

	@Transactional
	@Override
	public void deleteFromCart(long customerId, int productId) throws ProductNotFoundException {
		log.info("customerId:{},productId:{}",customerId,productId);
		Cart c = repository.findByUserIdAndProductId(customerId, productId);
		if (c != null) {
			repository.delete(c);
		} else
			throw new ProductNotFoundException("Product with id" + productId + "is not in the cart.");
		log.info("<-------Product delete from cart---------(service method ends)");
	}

	@Transactional
	@Override
	public void deleteFromWishlist(long customerId, int productId) throws ProductNotFoundException {
		log.info("customerId:{},productId:{}",customerId,productId);
		VendorWishlist vwl = wlrepo.findByCustomerIdAndProductId(customerId, productId);
		if (vwl != null) {
			wlrepo.delete(vwl);
			// return ResponseEntity.status(HttpStatus.OK).body("Product with id " +
			// productId + "removed successfully");
		}
		// else
		// throw new ProductNotFoundException("Product with id" + productId + "is not in
		// the cart.");
		log.info("<-------Product delete from wishlist---------(service method ends)");
	}

	@Transactional
	@Override
	public List<CartRequest> getCart(String token, long customerId) {
		log.info("getCart service method with token:{},customerId:{}",token,customerId);
		List<CartRequest> cartRequest = new ArrayList<CartRequest>();
		List<Cart> cartList = repository.findByUserId(customerId);
		for (Cart cart : cartList) {
			cartRequest.add(new CartRequest(customerId, client.searchProductById(token, cart.getProductId()).getBody(),
					cart.getQty(), cart.getZipcode(), cart.getDeliveryDate()));

		}
		// log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>inside get
		// cart qty="+cartRequest.get(0).getQty());
		log.info("Get cart service method ends");
		return cartRequest;
	}

	@Transactional
	@Override
	public List<Product> getWishlist(String token, long customerId) {
		log.info("token:{}",token);
		List<VendorWishlist> list = wlrepo.findByCustomerId(customerId);
		List<Product> products = new ArrayList<Product>();
		for (VendorWishlist wish : list) {
			products.add(client.searchProductById(token, wish.getProductId()).getBody());
		}
		log.info("Get wishlist service method ends");
		return products;
	}

	@Override
	public void updateCart(long customerId, int productId, int qty) {
		log.info("customerId:{},productId:{},qty:{}",customerId,productId,qty);
		// ResponseEntity<Product> p = client.searchProductById(token,productId);
		Cart c = repository.findByUserIdAndProductId(customerId, productId);
		if (qty >= 1) {
			if (c != null) {
				c.setQty(qty);
				repository.save(c);
				// return ResponseEntity.status(HttpStatus.OK).body();
			}
		}
		log.info("<-------update cart---------(service method ends)");
	}

	@Override
	public void updateVendor(String token, long customerId, int productId, int qty, int vendorId) {
		log.info("token:{},customerId:{},productId:{},vendorId:{}",token,customerId,productId,vendorId);
		List<Vendor> vendors = vclient.getVendors(token, productId, qty);
		Cart c = repository.findByUserIdAndProductId(customerId, productId);
		for (Vendor vendor : vendors) {
			if (vendor.getVendorId() == vendorId) {
				c.setVendorId(vendorId);
				repository.save(c);
				break;
			}
		}
		log.info("<-------update vendor---------(service method ends)");
	}

	@Override
	public List<Vendor> getVendors(String token, int productId, int qty) {
		log.info("Getting vendors SERVICE STARTS");
		log.info("Getting vendors SERVICE ENDS");
		return vclient.getVendors(token, productId, qty);
	}

	@Override
	public double getDeliveryCharge(String token, long customerId) {
		log.info("START getDeliveryCharge() with :{}",token);
		/*
		 * List<Vendor> vendors=getVendors(token,productId,qty); long dcharge=0; for
		 * (Vendor vendor : vendors) { if(vendor.getVendorId()==vendorId) {
		 * dcharge=vendor.getDeliveryCharge(); break; } }
		 */
		double dcharge = 0;
		List<Cart> items = repository.findByUserId(customerId);
		for (Cart cart : items) {
			log.info("Id:{}", cart.getVendorId());
			dcharge += vclient.getDeliveryCharge(token, cart.getVendorId());
		}
		log.info("END getDeliveryCharge() service");
		return dcharge;
	}

	@Override
	public float calculateTotalForCart(String token, long customerId) {
		log.info("START calculateTotalForCart() with :{}",token);
		float total = 0.0f;
		List<CartRequest> cr = getCart(token, customerId);
		for (CartRequest cartRequest : cr) {
			total += cartRequest.getProduct().getPrice() * cartRequest.getQty();
		}
		log.info("END calculateTotalForCart() service");
		return total;
	}

}
