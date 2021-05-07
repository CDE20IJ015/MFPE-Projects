package com.cts.retailproductauthms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.retailproductauthms.exception.PasswordNotMatchException;
import com.cts.retailproductauthms.exception.UserAlreadyExistsException;
import com.cts.retailproductauthms.model.Customer;
import com.cts.retailproductauthms.model.LoginCustomer;
import com.cts.retailproductauthms.service.CustomerDetails;
import com.cts.retailproductauthms.util.JwtUtil;

import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	CustomerDetails customerDetails;
	
	@PostMapping(value = "/register")
	public ResponseEntity<?> register(@RequestBody Customer customer) throws UserAlreadyExistsException, PasswordNotMatchException {

		log.info("Inside class AuthController!!! RegisterMethod");
		log.info("Registering user");
		log.info("{}",customer);
		if(customerDetails.addUser(customer))
		{
			return login(new LoginCustomer(customer.getUname(),customer.getUpassword()));
		}
		else
			throw new UserAlreadyExistsException("Not able to register");
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginCustomer user) throws PasswordNotMatchException {
		log.info("Inside login");
		UserDetails userDetails = customerDetails.loadUserByUsername(user.getUname());
		if(!user.getPassword().equals(userDetails.getPassword()))
			throw new PasswordNotMatchException("Password is Incorrect");
		return ResponseEntity.status(HttpStatus.OK).body(jwtUtil.generateToken(userDetails));
	}
	
	@GetMapping("/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String bearerToken) throws JwtException{
		log.info("Inside class AuthContoller!!! getValidityMethod");
		log.info("Validating");
		String token = bearerToken.substring(7);
		boolean res = false;
		if(jwtUtil.validateToken(token)) {
			log.info("Validation sucessful!!");
			res=true;
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/getId")
	public ResponseEntity<?> getId(@RequestHeader("Authorization") String bearerToken) {
		log.info("Inside class AuthContoller!!! getId");
		String token = bearerToken.substring(7);
		long res = customerDetails.getId(jwtUtil.extractUsername(token));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@GetMapping("/getZip")
	public ResponseEntity<?> getZip(@RequestHeader("Authorization") String bearerToken) {
		log.info("Inside class AuthContoller!!! getZip");
		String token = bearerToken.substring(7);
		int zipCode = customerDetails.getZip(jwtUtil.extractUsername(token));
		return new ResponseEntity<>(zipCode, HttpStatus.OK);
	}
}
