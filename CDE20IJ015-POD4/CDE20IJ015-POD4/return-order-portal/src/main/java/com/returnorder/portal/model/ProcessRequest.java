package com.returnorder.portal.model;

import javax.persistence.Entity;
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
@Table(name = "process_request")
public class ProcessRequest {

	@Id
	private int userID;
	private String username;
	private long contactNumber;
	private long creditCardNumber;
	private String componentType;
	private String componentName;
	private int quantityOfDefective;
	private boolean isPriorityRequest;

}
