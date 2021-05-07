package com.cts.retailproductproceedToBuyservice.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="wishlist")
@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VendorWishlist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wishlistId;
	private long customerId;
	private int productId;
	private int quantity;
	private LocalDate addingDateToWishlist;
}

