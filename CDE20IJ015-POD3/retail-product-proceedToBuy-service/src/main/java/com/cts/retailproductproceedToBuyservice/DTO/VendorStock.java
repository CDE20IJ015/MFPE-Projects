package com.cts.retailproductproceedToBuyservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorStock {
	public long vendorStockId;
	public int productId;
	public int vendorId;
	public long stockInHand;
	public String expectedStockReplinshmentDate;
}