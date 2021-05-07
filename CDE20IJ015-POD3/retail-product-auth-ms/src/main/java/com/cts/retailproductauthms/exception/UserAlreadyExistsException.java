package com.cts.retailproductauthms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User ALready Exists")
public class UserAlreadyExistsException extends Exception{

	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
}
