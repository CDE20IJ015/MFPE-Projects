package com.returnorder.component.model;

import javax.persistence.Entity;
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

/*
 * Sample JSON Format
{
    "userID": 5,
    "userName": "XYZ",
    "contactNumber": 9874563210,
    "creditCardNumber": 1234567890,
    "componentType": "integral",
    "componentName": "Motor",
    "quantityOfDefective": 2,
    "isPriorityRequest": true
}
*/