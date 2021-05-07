package com.cts.retailproductauthms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.retailproductauthms.model.Customer;

@Repository
public interface UserDao extends JpaRepository<Customer, String>{

	Optional<Customer> findByUname(String userName);

}
