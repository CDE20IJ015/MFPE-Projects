package com.cts.retailproductauthms.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cts.retailproductauthms.exception.UserAlreadyExistsException;
import com.cts.retailproductauthms.model.Customer;

public interface CustomerDetails extends UserDetailsService{

	boolean addUser(Customer user) throws UserAlreadyExistsException;
	
	long getId(String extractUsername);

	int getZip(String extractUsername);
	
	Customer getUser(String extractUsername);
}
