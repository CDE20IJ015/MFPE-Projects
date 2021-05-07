package com.cts.retailproductauthms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Password is Incorrect")
public class PasswordNotMatchException extends Exception{

	public PasswordNotMatchException(String msg){
		super(msg);
	}
}
