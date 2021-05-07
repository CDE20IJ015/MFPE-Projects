package com.cts.retailproductproceedToBuyservice.client;

public class AuthClientFallback implements AuthClient {

	@Override
	public boolean getValidity(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getId(String token) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getZip(String token) {
		// TODO Auto-generated method stub
		return 0;
	}

}

