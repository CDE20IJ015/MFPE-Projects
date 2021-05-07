package com.cts.retailproductvendor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;

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

import com.cts.retailproductvendor.exception.AccessUnauthorizedException;
import com.cts.retailproductvendor.feign.AuthClient;
import com.cts.retailproductvendor.model.Vendor;
import com.cts.retailproductvendor.service.VendorService;
import com.cts.retailproductvendor.service.VendorStockService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
class VendorRestControllerTest {
	@Autowired
	private MockMvc mock;
	@MockBean
	private VendorStockService vendorStockService;
	@MockBean
	private VendorService vendorService;
	@MockBean
	private AuthClient authClient;
	
	@Test
	void testGetVendors() throws Exception {		
	Vendor v = new Vendor(1,"Test", 100.0, 4.5);
	when( vendorStockService.getVendors(1,5)).thenReturn(Arrays.asList(v));
	when(authClient.getValidity("Bearer token")).thenReturn(true);
	MvcResult mvcResult = mock.perform(get("/getVendorDetails/1/5").header("Authorization", "Bearer token").accept("application/json")).andReturn();
	assertEquals(200, mvcResult.getResponse().getStatus());
	assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Test"));
	}
	
	@Test
	void testGetVendorsAccessUnauthorizedException() throws Exception {		
	Vendor v = new Vendor(1,"Test", 100.0, 4.5);
	when( vendorStockService.getVendors(1,5)).thenReturn(Arrays.asList(v));
	when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
	MvcResult mvcResult = mock.perform(get("/getVendorDetails/1/5").header("Authorization", "Bearer token").accept("application/json")).andReturn();
	assertEquals(403, mvcResult.getResponse().getStatus());
	assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));
	}

	@Test
	void testGetDeliveryCharge() throws Exception {
		when( vendorService.getDeliveryCharge(1)).thenReturn(Double.valueOf(100.0));
		when(authClient.getValidity("Bearer token")).thenReturn(true);
		MvcResult mvcResult = mock.perform(get("/getDeliveryCharge/1").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("100.0"));
	}
	
	@Test
	void testGetDeliveryChargeAccessUnauthorizedException() throws Exception {
		when( vendorService.getDeliveryCharge(1)).thenReturn(Double.valueOf(100.0));
		when(authClient.getValidity("Bearer token")).thenThrow(new AccessUnauthorizedException("Invalid token"));
		MvcResult mvcResult = mock.perform(get("/getDeliveryCharge/1").header("Authorization", "Bearer token").accept("application/json")).andReturn();
		assertEquals(403, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Invalid token"));
	}


}
