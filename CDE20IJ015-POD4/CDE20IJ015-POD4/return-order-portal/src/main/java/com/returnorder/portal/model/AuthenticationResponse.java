package com.returnorder.portal.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AuthenticationResponse {
	private int userID;
	private String jwtToken;
	private Boolean valid;

}
