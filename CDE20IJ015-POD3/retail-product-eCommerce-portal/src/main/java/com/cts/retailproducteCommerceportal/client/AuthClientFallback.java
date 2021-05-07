package com.cts.retailproducteCommerceportal.client;

import com.cts.retailproducteCommerceportal.model.LoginCustomer;
import com.cts.retailproducteCommerceportal.model.UserAuth;

public class AuthClientFallback implements AuthClient {

	@Override
	public boolean getValidity(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String login(LoginCustomer user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String register(UserAuth userAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getId(String token) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getZip(String token) {
		// TODO Auto-generated method stub
		return 0;
	}

}
