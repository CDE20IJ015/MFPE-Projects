package com.returnorder.authentication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.returnorder.authentication.model.MyUser;
import com.returnorder.authentication.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser cusUser =  userRepository.findByUsername(username);
		return new User(cusUser.getUsername(),cusUser.getPassword(),new ArrayList<>());
	}

	public int getUserId(String username) throws UsernameNotFoundException {
		return userRepository.getUserById(username);
	}

	
}
