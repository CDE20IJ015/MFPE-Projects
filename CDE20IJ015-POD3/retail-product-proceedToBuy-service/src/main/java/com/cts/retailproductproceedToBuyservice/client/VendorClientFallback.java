package com.cts.retailproductproceedToBuyservice.client;

import java.util.List;

import com.cts.retailproductproceedToBuyservice.DTO.Vendor;

public class VendorClientFallback implements VendorClient{

	@Override
	public List<Vendor> getVendors(String token, int productId, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public double getDeliveryCharge(String token, int vendorId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
