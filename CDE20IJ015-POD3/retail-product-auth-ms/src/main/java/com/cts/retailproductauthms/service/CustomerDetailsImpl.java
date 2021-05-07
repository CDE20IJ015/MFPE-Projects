package com.cts.retailproductauthms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.retailproductauthms.dao.UserDao;
import com.cts.retailproductauthms.exception.UserAlreadyExistsException;
import com.cts.retailproductauthms.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerDetailsImpl implements CustomerDetails{

	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info(username);
		Customer custDetails = userDao.findByUname(username).orElseThrow(
				() -> new UsernameNotFoundException("User details of the user "+username+" not found"));
		return new User(custDetails.getUname(), custDetails.getUpassword(), new ArrayList<>());
	}

	@Override
	public long getId(String extractUsername) {
		// TODO Auto-generated method stub
		return userDao.findByUname(extractUsername).get().getUserid();
	}

	@Override
	public boolean addUser(Customer cust) throws UserAlreadyExistsException {
		if(!userDao.findByUname(cust.getUname()).isEmpty())
			throw new UserAlreadyExistsException("User with username:"+cust.getUname()+" already exists");
		return userDao.save(cust)!=null;
	}

	@Override
	public Customer getUser(String extractUsername) {
		// TODO Auto-generated method stub
		return userDao.findByUname(extractUsername).get();
	}
	
	@Override
	public int getZip(String extractUsername) {
		// TODO Auto-generated method stub
		return userDao.findByUname(extractUsername).get().getZcode();
	}

}
