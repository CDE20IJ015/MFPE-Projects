package com.cts.retailproductauthms.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.retailproductauthms.service.CustomerDetails;
import com.cts.retailproductauthms.util.JwtUtil;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class AuthControllerTest {

	@Autowired
	private MockMvc mock;
	@MockBean
	CustomerDetails custDetail;
	@MockBean
	JwtUtil jwtutil;
	@Test
	void testTest() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetValidity() throws Exception {
		
		when(jwtutil.validateToken("Bearer token")).thenReturn(true);
		mock.perform(get("/validate").header("Authorization", "Bearer token").accept("application/json")).andExpect(status().isOk());
	}

	@Test
	void testGetId() throws Exception {
		when(jwtutil.validateToken("Bearer token")).thenReturn(true);
		mock.perform(get("/getId").header("Authorization", "Bearer token").accept("application/json")).andExpect(status().isOk());
	}

	@Test
	void testGetZip() throws Exception {
		when(jwtutil.validateToken("Bearer token")).thenReturn(true);
		mock.perform(get("/getZip").header("Authorization", "Bearer token").accept("application/json")).andExpect(status().isOk());
	}
}
