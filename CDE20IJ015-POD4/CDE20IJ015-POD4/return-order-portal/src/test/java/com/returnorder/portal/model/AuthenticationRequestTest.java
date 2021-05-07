package com.returnorder.portal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.returnorder.portal.model.AuthenticationRequest;

public class AuthenticationRequestTest {

	AuthenticationRequest authenticationRequest = new AuthenticationRequest();
	
	@Test
	void testGetUserName() {
		authenticationRequest.setUsername("Shuvam");
		assertEquals("Shuvam", authenticationRequest.getUsername());
	}
	
	@Test
	void testSetUserName() {
		authenticationRequest.setUsername("Shuvam");
		assertEquals("Shuvam", authenticationRequest.getUsername());
	}
	@Test
	void testGetPassword() {
		authenticationRequest.setPassword("Shuvam");
		assertEquals("Shuvam", authenticationRequest.getPassword());
	}
	
	@Test
	void testSetPassword() {
		authenticationRequest.setPassword("Shuvam");
		assertEquals("Shuvam", authenticationRequest.getPassword());
	}
	
	@Test
	void testConstructor() {
		AuthenticationRequest ar = new AuthenticationRequest("Shuvam", "Shuvam");
		assertEquals("Shuvam", ar.getUsername());
		assertEquals("Shuvam", ar.getPassword());
	}
}