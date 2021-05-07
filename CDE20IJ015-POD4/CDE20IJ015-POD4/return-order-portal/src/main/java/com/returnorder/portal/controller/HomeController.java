package com.returnorder.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.returnorder.portal.dao.MyUserRepository;
import com.returnorder.portal.model.AuthenticationRequest;
import com.returnorder.portal.model.AuthenticationResponse;
import com.returnorder.portal.service.LoginService;

@Controller
public class HomeController {

	static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LoginService loginService;

	@Autowired
	private AuthenticationRequest authenticationRequest;

	@Autowired
	private AuthenticationResponse authenticationResponse;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MyUserRepository myUserRepository;
	
	@RequestMapping("/")
	public String open() {

		return "login.jsp";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {

		logger.info("Handling /login request");
		
		authenticationRequest.setUsername(username);
		authenticationRequest.setPassword(password);

		authenticationResponse = restTemplate.postForObject("http://authentication.eba-9mnvvicj.ap-south-1.elasticbeanstalk.com/login", authenticationRequest, AuthenticationResponse.class);
		
		String jwtToken = authenticationResponse.getJwtToken();
		boolean isValid = authenticationResponse.getValid();

		int userID = myUserRepository.getUserId(username);
		

		loginService.createUser(userID, username, password, jwtToken, isValid);
		
		boolean valid = authenticationResponse.getValid();
		
		if (valid)
			return "home.jsp";

		return "login.jsp";

	}
	

}