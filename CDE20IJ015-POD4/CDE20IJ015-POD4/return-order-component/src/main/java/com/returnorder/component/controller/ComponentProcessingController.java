package com.returnorder.component.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.returnorder.component.model.AuthenticationResponse;
import com.returnorder.component.model.ProcessRequest;
import com.returnorder.component.model.ProcessResponse;
import com.returnorder.component.repository.ProcessRequestRepository;
import com.returnorder.component.service.AccessoryPartService;
import com.returnorder.component.service.IntegralPartService;
import com.returnorder.component.service.PaymentService;



@RestController
public class ComponentProcessingController {
	
	static Logger logger = LoggerFactory.getLogger(ComponentProcessingController.class);
	
	@Autowired
	IntegralPartService integralPartService;
	@Autowired
	AccessoryPartService accessoryPartService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	ProcessRequestRepository processRequestRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	HttpHeaders headers;
	
	ProcessRequest processRequest;

	@PostMapping("/service")
	public ProcessResponse getProcessingDetails(@RequestHeader("Authorization") String token,
			@RequestBody ProcessRequest processRequest) throws Exception {
		
		logger.info("Handling /service request");
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		AuthenticationResponse authenticationResponse = null;
		try {
			
			authenticationResponse = restTemplate.exchange("http://authentication.eba-9mnvvicj.ap-south-1.elasticbeanstalk.com/validate", HttpMethod.GET, entity, AuthenticationResponse.class).getBody(); 
			boolean valid=authenticationResponse.getValid();
			if(!valid)
				return null;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Authorization Failed. Please try again");
		}
		
		this.processRequest = processRequest;
		processRequestRepository.save(processRequest);
		ProcessResponse response = null;
		int userID = processRequest.getUserID();
		String componentType = processRequest.getComponentType();
		if (componentType.equals("integral"))
			response = (integralPartService.processDetail(userID));
		else if (componentType.equals("accessory"))
			response = (accessoryPartService.processDetail(userID));
		return response;
	}

	@PostMapping("/payment/{requestID}/{creditCardNumber}/{creditLimit}/{processingCharge}")
	public String paymentProcessing(@RequestHeader("Authorization") String token,
			@PathVariable("requestID") int requestID, @PathVariable("creditCardNumber") long creditCardNumber,
			@PathVariable("creditLimit") double creditLimit,
			@PathVariable("processingCharge") double processingcharge) throws Exception {
		
		logger.info("Processing the order");
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		AuthenticationResponse authenticationResponse = null;
		try {	
			authenticationResponse = restTemplate.exchange("http://authentication.eba-9mnvvicj.ap-south-1.elasticbeanstalk.com/validate", HttpMethod.GET, entity, AuthenticationResponse.class).getBody(); 
			
			if(!authenticationResponse.getValid())
				return null;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Authorization Failed. Please try again");
		}
		
		this.processRequest.setCreditCardNumber(creditCardNumber);
		processRequestRepository.save(processRequest);
		return paymentService.completeProcessing(requestID, creditCardNumber, creditLimit, processingcharge);
	}
}
