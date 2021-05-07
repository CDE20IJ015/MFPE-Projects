package com.returnorder.component.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.returnorder.component.model.ProcessRequest;
import com.returnorder.component.model.ProcessResponse;
import com.returnorder.component.repository.ProcessRequestRepository;
import com.returnorder.component.repository.ProcessResponseRepository;

@Service
public class AccessoryPartService implements ProcessService {
	
	static Logger logger = LoggerFactory.getLogger(AccessoryPartService.class);
	
	@Autowired
	private ProcessRequestRepository processRequestRepository;
	@Autowired
	private ProcessResponseRepository processResponseRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ProcessResponse processDetail(int userID) {
		double packagingAndDeliveryCharge;
		int processingDays = 5;
		double processingCharge = 300;
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		
		ProcessResponse processResponse = new ProcessResponse();
		
		Optional<ProcessRequest> result = processRequestRepository.findById(userID);
		ProcessRequest processRequest = result.get();
		
		c.add(Calendar.DATE, processingDays);
		
		processResponse.setUserID(userID);
		processResponse.setProcessingCharge(processingCharge);
		
		logger.info("Calling Packaging and Delivery Microservice to get packaging cost Input to give - Component Type, Count Charge Output to receive - Packaging and Delivery charge");
		
		String url ="http://packaging-delivery.eba-9mnvvicj.ap-south-1.elasticbeanstalk.com/PackagingAndDeliveryCharge/" + processRequest.getComponentType() + "/" + processRequest.getQuantityOfDefective();
		packagingAndDeliveryCharge = restTemplate.getForObject(url, Double.class);
		
		processResponse.setPackagingAndDeliveryCharge(packagingAndDeliveryCharge);
		processResponse.setDateOfDelivery(dateFormat.format(c.getTime()));
		processResponseRepository.save(processResponse);
		return processResponse;
	}
}
