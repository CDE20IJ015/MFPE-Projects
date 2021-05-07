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
@Table(name = "user_details") 
public class UserDetails {
	@Id
	private int userID;
	private String userName;
	private String password;
	private String jwtToken;
	private boolean isValid;

}
