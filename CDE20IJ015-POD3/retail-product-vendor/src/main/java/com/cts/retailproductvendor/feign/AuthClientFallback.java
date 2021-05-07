package com.cts.retailproductvendor.feign;

public class AuthClientFallback implements AuthClient {

	@Override
	public boolean getValidity(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getId(String token) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
