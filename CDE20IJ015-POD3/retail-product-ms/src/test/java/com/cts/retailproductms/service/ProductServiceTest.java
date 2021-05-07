package com.cts.retailproductms.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.retailproductms.dao.ProductDao;
import com.cts.retailproductms.exception.ProductNotFoundException;
import com.cts.retailproductms.model.Product;
import com.cts.retailproductms.service.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

	@InjectMocks
	ProductService productService;
	
	@Mock
	ProductDao dao;
	
	static Product p;
	
	@BeforeAll
	static void initilizeProduct() {
		p = new Product(1, 2500, "Shoes", "Fully comfort shoe", "addidas.jpeg",1,1);
	}

	@Test
	void testSearchProductById() {
		when(dao.findById(1L)).thenReturn(Optional.ofNullable(p));
		assertEquals(productService.searchProductById(1).get().getName(), p.getName());

	}
	
	@Test
	void testGetProductByName() {
		List<Product> p = Stream.of(new Product(1, 2500, "Shoes", "Fully comfort shoe", "addidas.jpeg",1,1),
				new Product(1, 2500, "Shoes", "Fully comfort shoe", "addidas.jpeg",1,1)).collect(Collectors.toList());
		when(dao.findByNameIgnoreCaseContaining("Shoes")).thenReturn(p);
		assertEquals(productService.searchProductByName("Shoes").size(), 2);
		verify(dao).findByNameIgnoreCaseContaining("Shoes");
	}

	@Test
	void testAddRatings() throws ProductNotFoundException {
		when(dao.findById(1L)).thenReturn(Optional.of(p));
		productService.addProductRating(1,5);
		verify(dao).save(p);
	}
	
	@Test
	void testAddRatingsProductNotFoundException() {
		when(dao.findById(1L)).thenReturn(Optional.empty());
		Exception exception = assertThrows(ProductNotFoundException.class, () ->productService.addProductRating(1, 5));
		assertEquals("No product found with product id "+1, exception.getMessage());
	}
	
	@Test
	void testGetAllProducts() {
		List<Product> p = Stream.of(new Product(1, 2500, "Shoes", "Fully comfort shoe", "addidas.jpeg",1,1),
				new Product(1, 2500, "Shoes", "Fully comfort shoe", "addidas.jpeg",1,1)).collect(Collectors.toList());
		when(dao.findAll()).thenReturn((List<Product>) p);
		assertEquals(productService.getAllProducts().size(), 2);
	}

}
