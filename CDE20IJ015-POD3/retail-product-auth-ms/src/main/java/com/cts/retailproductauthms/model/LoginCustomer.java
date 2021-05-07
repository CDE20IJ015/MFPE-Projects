package com.cts.retailproductauthms.model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginCustomer {

	@NotNull
	private String uname;
	@NotNull
	private String password;
}
