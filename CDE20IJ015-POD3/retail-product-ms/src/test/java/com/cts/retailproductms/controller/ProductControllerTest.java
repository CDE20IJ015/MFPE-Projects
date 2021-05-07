package com.cts.retailproductms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cts.retailproductms.exception.UnauthorisedAccessException;
import com.cts.retailproductms.feign.AuthFeign;
import com.cts.retailproductms.model.Product;
import com.cts.retailproductms.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class ProductControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	ProductService productService;
	
	@MockBean
	AuthFeign authClient;

	ObjectMapper mapper=new ObjectMapper();
	
	static Product p;
	
	@BeforeAll
	static void initilizeProduct() {
		p = new Product(1, 2500, "Shoes", "Fully comfort shoe", "addidas.jpeg",1,1);
	}

	@Test
	public void testSearchProductById() throws Exception {
		
		when(productService.searchProductById(1)).thenReturn(Optional.of(p));
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(get("/searchProductById/1").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Shoes"));
	}
	@Test
	public void testSearchProductByIdProductNotFoundException() throws Exception {
		
		when(productService.searchProductById(1)).thenReturn(Optional.empty());
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(get("/searchProductById/1").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("No product with product id "+1+" is present"));
	}

	@Test
	public void testSearchProductByIdAccessUnauthorizedException() throws Exception {
		
		when(productService.searchProductById(1)).thenReturn(Optional.of(p));
		when(authClient.getValidity("Bearer token")).thenThrow(new UnauthorisedAccessException("You dont have permission to access"));
		MvcResult mvcResult = mock.perform(get("/searchProductById/1").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("You dont have permission to access"));
	}

	@Test
	public void testSearchProductByName() throws Exception {
		when( productService.searchProductByName("shoe")).thenReturn(Arrays.asList(p));
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(get("/searchProductByName/shoe").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Shoes"));
		
	}
	
	@Test
	public void testSearchProductByNameProductNotFoundException() throws Exception {
		when( productService.searchProductByName("shoe")).thenReturn(Collections.emptyList());
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(get("/searchProductByName/shoe").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("No product with name "+"shoe"+" is present"));	
	}
	
	@Test
	public void testSearchProductByNameAccessUnauthorizedException() throws Exception {
		
		when( productService.searchProductByName("shoes")).thenReturn(Arrays.asList(p));
		when(authClient.getValidity("Bearer token")).thenThrow(new UnauthorisedAccessException("You dont have permission to access"));
		MvcResult mvcResult = mock.perform(get("/searchProductByName/shoe").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("You dont have permission to access"));
		
	}

	@Test
	public void testAddProductRating() throws Exception {
		//when( productService.addRatings(1,3)).thenReturn(Arrays.asList(p));
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		when(productService.addProductRating(1, 3)).thenReturn(p);
		MvcResult mvcResult = mock.perform(post("/addProductRating/1/3").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Rating submitted successfully"));
	}
	
	@Test
	public void testAddProductRatingAccessUnauthorizedException() throws Exception {
		//when( productService.addRatings(1,3)).thenReturn(Arrays.asList(p));
		when(authClient.getValidity("Bearer token")).thenThrow(new UnauthorisedAccessException("You dont have permission to access"));
		MvcResult mvcResult = mock.perform(post("/addProductRating/1/3").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("You dont have permission to access"));
	}

	@Test
	public void testGetAllProducts() throws Exception {
		when( productService.getAllProducts()).thenReturn(Arrays.asList(p));
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(get("/getAllProduct").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Shoes"));
	}
	
	@Test
	public void testGetAllProductsProductNotFoundException() throws Exception {
		when( productService.getAllProducts()).thenReturn(new ArrayList<Product>());
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(get("/getAllProduct").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("No products found"));
	}
	
	@Test
	public void testGetProductsAccessUnauthorizedException() throws Exception {
		when( productService.getAllProducts()).thenReturn(Arrays.asList(p));
		when(authClient.getValidity("Bearer token")).thenThrow(new UnauthorisedAccessException("You dont have permission to access"));
		MvcResult mvcResult = mock.perform(get("/getAllProduct").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("You dont have permission to access"));
	}

}