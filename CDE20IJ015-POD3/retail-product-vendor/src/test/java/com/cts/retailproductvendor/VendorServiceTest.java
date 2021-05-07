package com.cts.retailproductvendor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.retailproductvendor.model.Vendor;
import com.cts.retailproductvendor.repository.VendorRepository;
import com.cts.retailproductvendor.service.VendorService;

@ExtendWith(MockitoExtension.class)
class VendorServiceTest {

	@InjectMocks
	VendorService service;
	@Mock
	VendorRepository repository;

	@Test
	void testGetVendor() {
		Optional<Vendor> v = Optional.of(new Vendor(1, "Jagjeet", 100, 3.5));
		when(repository.findById(1)).thenReturn(v);
		assertEquals(service.getVendor(1).get().vendorName, v.get().vendorName);
	}

	@Test
	void testGetDeliveryCharge() {
		Optional<Vendor> v = Optional.of(new Vendor(1, "Jagjeet", 100, 3.5));
		when(repository.findById(1)).thenReturn(v);
		assertEquals(service.getDeliveryCharge(1), v.get().deliveryCharge);
	}

}
