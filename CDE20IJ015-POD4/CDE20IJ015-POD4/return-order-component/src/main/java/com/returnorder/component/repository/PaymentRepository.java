package com.returnorder.component.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnorder.component.model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
