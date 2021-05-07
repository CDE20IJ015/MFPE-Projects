package com.returnorder.component.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "process_response")
public class ProcessResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestID;
	private int userID;
	private double processingCharge;
	private double packagingAndDeliveryCharge;
	private String dateOfDelivery;

}

/*
 * Sample JSON Format
{
    "requestID": 2,
    "userID": 2,
    "processingCharge": 300.0,
    "packagingAndDeliveryCharge": 400.0,
    "dateOfDelivery": "5"
}
 */
