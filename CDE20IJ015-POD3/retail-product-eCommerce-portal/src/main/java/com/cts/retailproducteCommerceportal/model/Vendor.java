package com.cts.retailproducteCommerceportal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

	public int vendorId;
	public String vendorName;
	public double deliveryCharge;
	public double rating;
}
