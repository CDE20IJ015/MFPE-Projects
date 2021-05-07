package com.cts.retailproductvendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.retailproductvendor.exception.AccessUnauthorizedException;
import com.cts.retailproductvendor.exception.InternalServerErrorException;
import com.cts.retailproductvendor.feign.AuthClient;
import com.cts.retailproductvendor.model.Vendor;
import com.cts.retailproductvendor.service.VendorService;
import com.cts.retailproductvendor.service.VendorStockService;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class VendorController {

	@Autowired
	VendorService vendorService;
	
	@Autowired
	VendorStockService vendorStockService;
	
	@Autowired
	AuthClient authClient;
	
	@GetMapping("/getVendorDetails/{productId}/{quantity}")
	public ResponseEntity<List<Vendor>> getVendors(@RequestHeader("Authorization") String token, 
			@PathVariable int productId, @PathVariable int quantity)throws AccessUnauthorizedException, InternalServerErrorException {
		
		log.info("Token: {}", token);
		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		return new ResponseEntity<>(vendorStockService.getVendors(productId, quantity), HttpStatus.OK);
	}
	
	@GetMapping("/getDeliveryCharge/{vendorId}")
	public ResponseEntity<Double> getDeliveryCharge(@RequestHeader("Authorization") String token,
			@PathVariable int vendorId)throws AccessUnauthorizedException, InternalServerErrorException {
		
		log.info("Token: {}", token);
		try {
			authClient.getValidity(token);
			log.info("Validation successful");
		}
		catch(FeignException f) {
			int httpStatus = f.status();
			switch(httpStatus) {
				case 401:
					throw new AccessUnauthorizedException("Invalid Token");
				default:
					throw new InternalServerErrorException("Authentication Service is Not Working");
			}
		}
		return new ResponseEntity<Double>(vendorService.getDeliveryCharge(vendorId), HttpStatus.OK);
	}
}
