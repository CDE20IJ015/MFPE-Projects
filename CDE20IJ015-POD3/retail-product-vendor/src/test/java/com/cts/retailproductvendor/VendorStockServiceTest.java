package com.cts.retailproductvendor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.retailproductvendor.model.Vendor;
import com.cts.retailproductvendor.repository.VendorStockRepository;
import com.cts.retailproductvendor.service.VendorService;
import com.cts.retailproductvendor.service.VendorStockService;

@ExtendWith(MockitoExtension.class)
class VendorStockServiceTest {
	
	@Mock
	VendorStockRepository repository;

	@InjectMocks
	VendorStockService service;

	@Mock
	VendorService service1;

	@Test
	void testGetVendors() {

		List<Integer> list = new ArrayList<>();
		list.add(Integer.valueOf(1));
		when(repository.getStock(1,2)).thenReturn(list);
		Vendor v = new Vendor(1, "Kumar", 100, 4.5);
		List<Vendor> vendors = new ArrayList<>();
		vendors.add(v);
		when(service1.getVendor(1)).thenReturn(Optional.of(v));
		assertEquals(service.getVendors(1, 2).get(0).getVendorId(), vendors.get(0).getVendorId());
	}

}
