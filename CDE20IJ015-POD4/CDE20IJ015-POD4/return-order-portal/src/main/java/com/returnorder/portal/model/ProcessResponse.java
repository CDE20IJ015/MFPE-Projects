package com.returnorder.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
