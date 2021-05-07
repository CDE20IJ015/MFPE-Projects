package com.cts.retailproducteCommerceportal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private int id;
	private String name;
	private float price;
	private String description;
	private String image_name;
	private float rating;
	private int count;
}
