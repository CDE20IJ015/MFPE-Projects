package com.returnorder.component.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.returnorder.component.model.Payment;
import com.returnorder.component.repository.PaymentRepository;

@Service
public class PaymentService {

	static Logger logger = LoggerFactory.getLogger(PaymentService.class);

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private RestTemplate restTemplate;

	public String completeProcessing(int requestID, long creditCardNumber, double creditLimit,
			double processingCharge) {
		double currentBalance = -1;
		String finalResponse = "";

		Payment payment = new Payment();
		payment.setRequestID(requestID);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setCreditLimit(creditLimit);
		payment.setProcessingCharge(processingCharge);
		paymentRepository.save(payment);

		logger.info("Calling Payment Microservice");
		
		String url ="http://payment.eba-9mnvvicj.ap-south-1.elasticbeanstalk.com/card/" + creditCardNumber + "/" + processingCharge;
		currentBalance = restTemplate.getForObject(url , Double.class);
		
		if (currentBalance <= -1)
			finalResponse = "We are sorry. Your payment could not be processed due to insufficient limit.";
		else
			finalResponse = "Your Payment is successful. Thank you for using our service.";

		if (currentBalance == Integer.MIN_VALUE)
			finalResponse = "Wrong card details";
		
		return finalResponse;
	}

}
