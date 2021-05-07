package com.returnorder.payment.service;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnorder.payment.dao.CardRepo;
import com.returnorder.payment.exception.CardNotFoundException;
import com.returnorder.payment.model.CreditCard;


@Service
public class CardService {
	
	static Logger logger = LoggerFactory.getLogger(CardService.class);

	@Autowired
	CardRepo cardRepo;
	
	@Transactional
	public double processPayment(long cardNumber,double charge) throws NoSuchElementException, CardNotFoundException {
	
		logger.info("Processing payment");
		
		CreditCard card=cardRepo.findByCardNumber(cardNumber);
		if(card==null)throw new CardNotFoundException();
		double balance= card.getCardLimit()-charge;
		if(balance>0)
		{
			card.setCardLimit(balance);
			cardRepo.save(card);
			return balance;
			
		}
		else {
			return -1;
		}
	}
}
