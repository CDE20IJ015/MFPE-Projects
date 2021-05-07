package com.cts.retailproductproceedToBuyservice.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
	
	private long customerId;
	private Product product;
	private int qty;
	private int zipCode;
	private Date expectedDeliveryDate;
	
}