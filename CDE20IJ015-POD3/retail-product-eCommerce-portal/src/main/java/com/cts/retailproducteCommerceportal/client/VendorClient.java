package com.cts.retailproducteCommerceportal.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.retailproducteCommerceportal.exception.UnauthorisedAccessException;
import com.cts.retailproducteCommerceportal.model.Vendor;

@FeignClient(name = "vendorclient", url = "${feign.url.vendor-ms}/", fallback = VendorClientFallback.class)
public interface VendorClient {

	@GetMapping("getVendorDetails/{productId}/{quantity}")
	public List<Vendor> getVendors(@RequestHeader("Authorization") String token, 
			@PathVariable int productId, @PathVariable int quantity)throws UnauthorisedAccessException;
}
