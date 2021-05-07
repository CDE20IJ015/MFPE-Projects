package com.cts.retailproductvendor.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.retailproductvendor.model.Vendor;
import com.cts.retailproductvendor.repository.VendorStockRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VendorStockService {

	@Autowired
	VendorStockRepository vendorStockRepository;
	
	@Autowired
	VendorService vendorService;
	
	public List<Vendor> getVendors(int productId, int quantity) {
		log.info("productId: {}, quantity: {}",productId, quantity);
		
		//getting the vendor ids for the product id and quantity
		List<Integer> vendorIdList = vendorStockRepository.getStock(productId, quantity);
		
		//empty list of vendors to store the vendors for the given vendor ids
		List<Vendor> vendorList = new ArrayList<>();
		
		for(Integer vendorId : vendorIdList) {
			vendorList.add(vendorService.getVendor(vendorId).get());
		}
		
		Collections.sort(vendorList, new Comparator<Vendor>() {
			//comparing on the basis of ascending order of delivery charge, if same then on the basis of
			//descending order of rating
			@Override
			public int compare(Vendor v1, Vendor v2) {
				// TODO Auto-generated method stub
				
				if(v1.getDeliveryCharge() != v2.getDeliveryCharge()) {
					if(v1.getDeliveryCharge() < v2.getDeliveryCharge()) 
						return -1;
					else 
						return 1;
				}
				else {
					if(v1.getRating() > v2.getRating())
						return -1;
					else
						return 1;
				}
			}
		});
		return vendorList;
	}
}
