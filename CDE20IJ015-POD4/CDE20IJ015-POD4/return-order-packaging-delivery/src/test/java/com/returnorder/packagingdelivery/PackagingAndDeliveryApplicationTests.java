package com.returnorder.packagingdelivery;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.returnorder.packagingdelivery.service.PackagingAndDeliveryService;

@SpringBootTest
class PackagingAndDeliveryApplicationTests {

	PackagingAndDeliveryService packingAndDeliveryService = new PackagingAndDeliveryService();
	
	
	@Test
	void contextLoads() {
		assertTrue(true);
	}
	
	@Test
	void PackageAndDeliveryTestForIntegral() {
		double actualResult = packingAndDeliveryService.getPackingAndDeliveryCharge("integral", 10);
		double expectedResult = 3500.0;
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	void PackageAndDeliveryTestForAccessory() {
		double actualResult = packingAndDeliveryService.getPackingAndDeliveryCharge("accessory", 10);
		double expectedResult = 2000.0;
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	void PackageAndDeliveryTestForCountIsZero() {
		double actualResult = packingAndDeliveryService.getPackingAndDeliveryCharge("integral || accessory", 0);
		double expectedResult = 0;
		Assertions.assertEquals(expectedResult, actualResult);
	}

}