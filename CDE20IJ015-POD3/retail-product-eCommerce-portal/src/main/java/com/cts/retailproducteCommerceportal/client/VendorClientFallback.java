package com.cts.retailproducteCommerceportal.client;

import java.util.List;

import com.cts.retailproducteCommerceportal.exception.UnauthorisedAccessException;
import com.cts.retailproducteCommerceportal.model.Vendor;

public class VendorClientFallback implements VendorClient {

	@Override
	public List<Vendor> getVendors(String token, int productId, int quantity) throws UnauthorisedAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
