package com.cts.retailproductproceedToBuyservice.DTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Product {

	private int id;
	private String name;
	private float price;
	private String description;
	private String image_name;
	private float rating;
	private int count;
}

