package com.cts.retailproductvendor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.retailproductvendor.model.Vendor;
import com.cts.retailproductvendor.repository.VendorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VendorService {

	@Autowired
	VendorRepository vendorRepository;
	
	public Optional<Vendor> getVendor(int vendorId) {
		log.info("vendorId: {}",vendorId);
		return vendorRepository.findById(vendorId);
	}
	
	public double getDeliveryCharge(int vendorId) {
		log.info("vendorId: {}", vendorId);
		return vendorRepository.findById(vendorId).get().getDeliveryCharge();
	}
}
