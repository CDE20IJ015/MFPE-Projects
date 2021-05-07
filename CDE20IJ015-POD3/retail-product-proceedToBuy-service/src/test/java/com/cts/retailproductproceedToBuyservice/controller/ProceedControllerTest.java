package com.cts.retailproductproceedToBuyservice.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.sql.Date;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cts.retailproductproceedToBuyservice.DTO.CartRequest;
import com.cts.retailproductproceedToBuyservice.DTO.Product;
import com.cts.retailproductproceedToBuyservice.client.AuthClient;
import com.cts.retailproductproceedToBuyservice.client.VendorClient;
import com.cts.retailproductproceedToBuyservice.exception.AccessUnauthorizedException;
import com.cts.retailproductproceedToBuyservice.service.CartService;

@SpringBootTest
@AutoConfigureMockMvc
class ProceedControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private CartService service;
	
	@MockBean
	private AuthClient authClient;
	
	@MockBean
	VendorClient vendorClient;

	@Test
	void testAddProductToCart() throws Exception {
		// Product p = new Product(1, "Shoes", 2500, "Fully comfort shoe", "addidas");
		// when( productService.addRatings(1,3)).thenReturn(Arrays.asList(p));
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(post("/addProductToCart/1/12-12-2020")
				.header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(201, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Added successfully."));
		// verify(service).addProductToCart("Bearer token",1,1,1,any(),1);
	}

	@Test
	void testAddProductToCartAccessUnauthorizedException() throws Exception {
		// Product p = new Product(1, "Shoes", 2500, "Fully comfort shoe", "addidas");
		// when( productService.addRatings(1,3)).thenReturn(Arrays.asList(p));
		when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
		MvcResult mvcResult = mock.perform(post("/addProductToCart/1/12-12-2020")
				.header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));

		// verify(service).addProductToCart("Bearer token",1,1,1,any(),1);
	}

	@Test
	void testGetCart() throws Exception {
		Product p = new Product(1, "Shoes", 2500, "Fully comfort shoe", "addidas", 1, 1);
		CartRequest cr = new CartRequest(1, p, 1, 1, new Date(1, 1, 1));
		when(service.getCart("Bearer token", 0)).thenReturn(Arrays.asList(cr));
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock
				.perform(get("/getCart").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Shoes"));
	}

	@Test
	void testGetCartNotFound() throws Exception {
		Product p = new Product(1, "Shoes", 2500, "Fully comfort shoe", "addidas", 1, 1);
		CartRequest cr = new CartRequest(1, p, 1, 1, new Date(1, 1, 1));
		when(service.getCart("Bearer token", 0)).thenReturn(Arrays.asList());
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock
				.perform(get("/getCart").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Cart for user:=0 was not found."));
	}

	@Test
	void testGetCartAccessUnauthorizedException() throws Exception {
		Product p = new Product(1, "Shoes", 2500, "Fully comfort shoe", "addidas", 1, 1);
		CartRequest cr = new CartRequest(1, p, 1, 1, new Date(1, 1, 1));
		when(service.getCart("Bearer token", 0)).thenReturn(Arrays.asList(cr));
		when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
		MvcResult mvcResult = mock
				.perform(get("/getCart").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));

	}

	@Test
	void testGetWishlist() throws Exception {
		Product p = new Product(1, "Shoes", 2500, "Fully comfort shoe", "addidas", 1, 1);
		when(service.getWishlist("Bearer token", 0)).thenReturn(Arrays.asList(p));
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock
				.perform(get("/getWishlist").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Shoes"));
	}

	@Test
	void testGetWishlistNotFound() throws Exception {
		when(service.getWishlist("Bearer token", 0)).thenReturn(Arrays.asList());
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock
				.perform(get("/getWishlist").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
		assertEquals(true,
				mvcResult.getResponse().getContentAsString().contains("Wishlist for user:=0 was not found."));
	}

	@Test
	void testGetWishlistAccessUnauthorizedException() throws Exception {
		Product p = new Product(1, "Shoes", 2500, "Fully comfort shoe", "addidas", 1, 1);
		when(service.getWishlist("Bearer token", 0)).thenReturn(Arrays.asList(p));
		when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
		MvcResult mvcResult = mock
				.perform(get("/getWishlist").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));

	}

	@Test
	void testDeleteProductFromCart() throws Exception {
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(delete("/deleteProductFromCart/1")
				.header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true,
				mvcResult.getResponse().getContentAsString().contains("Product with id 1removed successfully"));
	}

	@Test
	void testDeleteProductFromCartAccessUnauthorizedException() throws Exception {
		Product p = new Product(1, "Shoes", 2500, "Fully comfort shoe", "addidas", 1, 1);
		when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
		when(service.getWishlist("Bearer token", 0)).thenReturn(Arrays.asList(p));
		MvcResult mvcResult = mock.perform(delete("/deleteProductFromCart/1")
				.header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));

	}

	@Test
	void testUpdateCart() throws Exception {
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock
				.perform(
						put("/updateCart/1/1").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Cart updated successfully"));
	}

	@Test
	void testUpdateCartAccessUnauthorizedException() throws Exception {
		when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
		MvcResult mvcResult = mock
				.perform(
						put("/updateCart/1/1").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));

	}

	@Test
	void testDeleteProductFromWishlist() throws Exception {
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(delete("/deleteProductFromWishlist/1")
				.header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true,
				mvcResult.getResponse().getContentAsString().contains("Product with id 1removed successfully"));
	}

	@Test
	void testDeleteProductFromWishlistAccessUnauthorizedException() throws Exception {
		when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
		MvcResult mvcResult = mock.perform(delete("/deleteProductFromWishlist/1")
				.header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));

	}

	@Test
	void testAddProductToWishList() throws Exception {
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(post("/addProductToWishlist/1/1")
				.header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(201, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Added to wishlist."));
	}

	@Test
	void testAddProductToWishListAccessUnauthorizedException() throws Exception {
		when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
		MvcResult mvcResult = mock.perform(post("/addProductToWishlist/1/1")
				.header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));

	}

	@Test
	void testUpdateVendor() throws Exception {
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(
				put("/updateVendor/1/1/1").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Vendor updated successfully"));
	}

	@Test
	void testUpdateVendorAccessUnauthorizedException() throws Exception {
		when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
		MvcResult mvcResult = mock.perform(
				put("/updateVendor/1/1/1").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));

	}

	@Test
	void testGetDeliveryCharge() throws Exception {
		when(service.getDeliveryCharge("Bearer token", 0)).thenReturn((double) 1);
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock
				.perform(post("/charge/").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("0"));
	}

	@Test
	void testGetDeliveryChargeAccessUnauthorizedException() throws Exception {
		when(service.getDeliveryCharge("Bearer token", 1)).thenReturn((double) 1);
		when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
		MvcResult mvcResult = mock
				.perform(post("/charge").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));

	}

	@Test
	void testCalculateTotalForCart() throws Exception {
		when(service.calculateTotalForCart("Bearer token", 0)).thenReturn((float) 1);
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock
				.perform(get("/total").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("0"));
	}

	@Test
	void testCalculateTotalForCartAccessUnauthorizedException() throws Exception {
		when(service.calculateTotalForCart("Bearer token", 0)).thenReturn((float) 1);
		when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
		MvcResult mvcResult = mock
				.perform(get("/total").header("Authorization", "Bearer token").accept("application/json"))
				.andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));

	}

}
