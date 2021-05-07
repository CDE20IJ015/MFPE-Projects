package com.cts.retailproducteCommerceportal.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {

	private int customerId;
	private Product product;
	private int qty;
	private int zipCode;
	private Date expectedDeliveryDate;
}
