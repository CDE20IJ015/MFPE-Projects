package com.cts.retailproductproceedToBuyservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vendor {
	public int vendorId;
	public String vendorName;
	public long deliveryCharge;
	public double rating;
}
