package com.returnorder.component.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ProcessRequestTest {
	ProcessRequest processRequest = new ProcessRequest();
	
	@Test
	void testGetUserID() {
		processRequest.setUserID(1);
		assertEquals(1, processRequest.getUserID());
	}
	
	@Test
	void testSetUserID() {
		processRequest.setUserID(1);
		assertEquals(1, processRequest.getUserID());
	}
	
	@Test
	void testGetUserName() {
		processRequest.setUsername("Lakshit");
		assertEquals("Lakshit", processRequest.getUsername());
	}
	
	@Test
	void testSetUserName() {
		processRequest.setUsername("Lakshit");
		assertEquals("Lakshit", processRequest.getUsername());
	}
	
	@Test
	void testGetContactNumber() {
		processRequest.setContactNumber(987456123);
		assertEquals(987456123, processRequest.getContactNumber());
	}
	
	@Test
	void testSetContactNumber() {
		processRequest.setContactNumber(987456123);
		assertEquals(987456123, processRequest.getContactNumber());
	}
	
	@Test
	void testGetCreditCardNumber() {
		processRequest.setCreditCardNumber(1234567890);
		assertEquals(1234567890, processRequest.getCreditCardNumber());
	}

	@Test
	void testSetCreditCardNumber() {
		processRequest.setCreditCardNumber(1234567890);
		assertEquals(1234567890, processRequest.getCreditCardNumber());
	}
	
	@Test
	void testGetComponentType() {
		processRequest.setComponentType("integral");
		assertEquals("integral", processRequest.getComponentType());
	}
	
	@Test
	void testSetComponentType() {
		processRequest.setComponentType("integral");
		assertEquals("integral", processRequest.getComponentType());
	}
	
	@Test
	void testGetComponentName() {
		processRequest.setComponentName("Laptop");
		assertEquals("Laptop", processRequest.getComponentName());
	}
	
	@Test
	void testSetComponentName() {
		processRequest.setComponentName("Laptop");
		assertEquals("Laptop", processRequest.getComponentName());
	}
	
	@Test
	void testGetQuantityOfDefective() {
		processRequest.setQuantityOfDefective(1);
		assertEquals(1, processRequest.getQuantityOfDefective());
	}
	
	@Test
	void testSetQuantityOfDefective() {
		processRequest.setQuantityOfDefective(1);
		assertEquals(1, processRequest.getQuantityOfDefective());
	}
	
	@Test
	void testGetPriorityRequest() {
		processRequest.setPriorityRequest(true);
		assertEquals(true, processRequest.isPriorityRequest());
	}
	
	@Test
	void testSetPriorityRequest() {
		processRequest.setPriorityRequest(true);
		assertEquals(true, processRequest.isPriorityRequest());
	}
	
	@Test
	void testConstructor() {
		ProcessRequest obj=new ProcessRequest(101, "Rohit", 9766875, 1234567, "integral", "Laptop", 2	, true);
		assertEquals(101, obj.getUserID());
		assertEquals("Rohit", obj.getUsername());
		assertEquals(9766875, obj.getContactNumber());
		assertEquals("integral", obj.getComponentType());
		assertEquals(1234567, obj.getCreditCardNumber());
		assertEquals("Laptop", obj.getComponentName());
		assertEquals(2, obj.getQuantityOfDefective());
		assertTrue(obj.isPriorityRequest());
		
	}
}
