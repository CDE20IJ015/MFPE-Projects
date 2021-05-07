package com.returnorder.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.returnorder.payment.exception.CardNotFoundException;
import com.returnorder.payment.model.CreditCard;

public interface CardRepo extends JpaRepository<CreditCard, String>{

	CreditCard findByCardNumber(long cardNumber)throws CardNotFoundException;

}
