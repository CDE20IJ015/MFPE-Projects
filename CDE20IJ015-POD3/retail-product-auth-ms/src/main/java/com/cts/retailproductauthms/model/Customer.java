package com.cts.retailproductauthms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

	@Id
	private long userid;
	
	@Column
	private String fname;
	
	@Column
	private String lname;
	
	@Column
	private String uname;
	
	@Column
	private String upassword;
	
	@Column
	private String email;
	
	@Column
	private String address;
	
	@Column
	private int zcode;
}
