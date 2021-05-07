package com.cts.retailproductms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	private long id;
	
	private double price;
	
	private String name;
	
	private String Description;
	
	private String image_name;
	
	private float rating;
	
	private int count;
}
