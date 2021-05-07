package com.cts.retailproducteCommerceportal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserAuth {

	private long userid;
	private String firstName;
	private String lastName;
	private String uname;
	private String upassword;
	private String email;
	private String address;
	private int zipCode;
}
