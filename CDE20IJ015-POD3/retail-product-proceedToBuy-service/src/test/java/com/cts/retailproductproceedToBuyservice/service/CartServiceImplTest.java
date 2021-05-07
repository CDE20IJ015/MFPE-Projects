package com.cts.retailproductproceedToBuyservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

@ExtendWith(MockitoExtension.class)
class CartServiceImplTest {

	@InjectMocks
	CartServiceImpl service;

	@Mock
	CartRepository repository;

	@Mock
	WishlistRepository wlrepo;

	@Mock
	ProductClient pc;

	@Mock
	AuthClient auth;

	@Mock
	VendorClient vclient;

	@Test
	void testAddProductToWishlist() {
		VendorWishlist vl = new VendorWishlist();
		vl.setCustomerId(1);
		vl.setProductId(1);
		vl.setQuantity(1);
		vl.setAddingDateToWishlist(LocalDate.now());
		service.addProductToWishlist(1, 1, 1);
		// verify(wlrepo).save( any(VendorWishlist.class));
		// when(wlrepo.findByCustomerIdAndProductId(5, 1)).thenReturn(vl);
	}

	@Test
	void testAddProductToCart() throws ProductNotFoundException {
		Product p = new Product(1, "coffee", 85, "desc", "abc", 4, 3);
		// Product p=pc.searchProductById(1);
		List<Vendor> list = new ArrayList<Vendor>();
		list.add(new Vendor(1, "test", 1, 1));
		when(pc.searchProductById("token", 1)).thenReturn(new ResponseEntity<Product>(p, HttpStatus.OK));
		when(vclient.getVendors("token", 1, 1)).thenReturn(list);

		Cart c = new Cart(1, 1, 1, 215014, new Date(), 1, 1);
		service.addProductToCart("token", c.getUserId(), p.getId(), c.getZipcode(), c.getDeliveryDate(),
				c.getVendorId());
	}


	@Test
	void testDeleteFromCart() throws ProductNotFoundException {
		Cart c = new Cart(1, 1, 1, 1, new Date(), 1, 1);
		when(repository.findByUserIdAndProductId(1, 1)).thenReturn(c);
		service.deleteFromCart(1, 1);
		// repository.delete(c);
		// when(repository.findById(1)).thenReturn(Optional.empty());
	}

	@Test
	void testDeleteFromCartQty() throws ProductNotFoundException {
		Cart c = new Cart(2, 2, 2, 2, new Date(), 2, 2);
		when(repository.findByUserIdAndProductId(2, 2)).thenReturn(c);
		service.deleteFromCart(2, 2);
		// repository.delete(c);
		// when(repository.findById(1)).thenReturn(Optional.empty());
	}

	@Test
	void testDeleteFromWishlist() throws ProductNotFoundException {
		VendorWishlist vl = new VendorWishlist(1, 1, 1, 1, LocalDate.now());
		when(wlrepo.findByCustomerIdAndProductId(1, 1)).thenReturn(vl);
		service.deleteFromWishlist(1, 1);
		// when(wlrepo.findById(41)).thenReturn(Optional.empty());
	}

	@Test
	void testDeleteFromWishlistNotFound() throws ProductNotFoundException {
		VendorWishlist vl = new VendorWishlist(1, 1, 1, 1, LocalDate.now());
		when(wlrepo.findByCustomerIdAndProductId(1, 1)).thenReturn(null);
		service.deleteFromWishlist(1, 1);
		// when(wlrepo.findById(41)).thenReturn(Optional.empty());
	}

	@Test
	void testGetCart() {
		List<Cart> c = new ArrayList<>();
		c.add(new Cart(1, 1, 1, 1, new Date(), 1, 1));
		Product p = new Product(1, "1", 1, "1", "1", 1, 1);
		when(repository.findByUserId(1)).thenReturn(c);
		when(pc.searchProductById("token", 1)).thenReturn(new ResponseEntity<Product>(p, HttpStatus.OK));
		assertEquals(service.getCart("token", 1).get(0).getCustomerId(), 1);
	}

	@Test
	void testGetWishlist() {
		List<VendorWishlist> wl = new ArrayList<>();
		wl.add(new VendorWishlist(1, 1, 1, 1, LocalDate.now()));
		when(wlrepo.findByCustomerId(1)).thenReturn(wl);
		Product p = new Product(1, "1", 1, "1", "1", 1, 1);
		when(pc.searchProductById("token", 1)).thenReturn(new ResponseEntity<Product>(p, HttpStatus.OK));
		assertEquals(service.getWishlist("token", 1).get(0).getId(), 1);
	}

	@Test
	void testUpdateCart() {
		Cart c = new Cart(1, 1, 1, 1, new Date(), 1, 1);
		when(repository.findByUserIdAndProductId(1, 1)).thenReturn(c);
		service.updateCart(1, 1, 1);
	}

	@Test
	void testUpdateCartNoCart() {
		Cart c = new Cart(1, 1, 1, 1, new Date(), 1, 1);
		when(repository.findByUserIdAndProductId(1, 1)).thenReturn(null);
		service.updateCart(1, 1, 1);
	}

	@Test
	void testUpdateCartQty0() {
		Cart c = new Cart(1, 1, 1, 1, new Date(), 1, 1);
		when(repository.findByUserIdAndProductId(1, 1)).thenReturn(c);
		service.updateCart(1, 1, 0);
	}

	@Test
	void testUpdateVendor() {
		List<Vendor> vendors = new ArrayList<Vendor>();
		vendors.add(new Vendor(1, "1", 1, 1));
		vendors.add(new Vendor(2, "2", 2, 2));
		when(vclient.getVendors("token", 2, 2)).thenReturn(vendors);
		when(repository.findByUserIdAndProductId(2, 2)).thenReturn(new Cart(2, 2, 2, 2, new Date(), 2, 2));
		service.updateVendor("token", 2, 2, 2, 2);

	}

	@Test
	void testUpdateVendorNoVendor() {
		List<Vendor> vendors = new ArrayList<Vendor>();
		// vendors.add(new Vendor(1, "1", 1, 1));
		// vendors.add(new Vendor(2, "2", 2, 2));
		when(vclient.getVendors("token", 2, 2)).thenReturn(vendors);
		when(repository.findByUserIdAndProductId(2, 2)).thenReturn(new Cart(2, 2, 2, 2, new Date(), 2, 2));
		service.updateVendor("token", 2, 2, 2, 2);

	}

	@Test
	void testGetVendors() {
		List<Vendor> vendors = new ArrayList<Vendor>();
		vendors.add(new Vendor(1, "1", 1, 1));
		when(vclient.getVendors("token", 1, 1)).thenReturn(vendors);
		assertEquals(service.getVendors("token", 1, 1).get(0).getVendorId(), 1);

	}

	@Test
	void testGetDeliveryCharge() {
		List<Cart> c = new ArrayList<>();
		c.add(new Cart(1, 1, 1, 1, new Date(), 1, 1));
		when(repository.findByUserId(1)).thenReturn(c);
		when(vclient.getDeliveryCharge("token", 1)).thenReturn((double) 1);
		assertEquals(service.getDeliveryCharge("token", 1), 1);
	}

	@Test
	void testCalculateTotalForCart() {
		List<Cart> c = new ArrayList<>();
		c.add(new Cart(1, 1, 1, 1, new Date(), 1, 1));
		Product p = new Product(1, "1", 1, "1", "1", 1, 1);
		when(repository.findByUserId(1)).thenReturn(c);
		when(pc.searchProductById("token", 1)).thenReturn(new ResponseEntity<Product>(p, HttpStatus.OK));
		assertEquals(service.calculateTotalForCart("token", 1), 1);
	}
}
