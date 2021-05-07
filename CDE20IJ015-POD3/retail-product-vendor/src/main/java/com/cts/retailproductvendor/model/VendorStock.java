package com.cts.retailproductvendor.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VendorStock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int vendorStockId;
	public int productId;
	public int vendorId;
	public int stockInHand;
	public LocalDate expectedStockReplinshmentDate;
}
