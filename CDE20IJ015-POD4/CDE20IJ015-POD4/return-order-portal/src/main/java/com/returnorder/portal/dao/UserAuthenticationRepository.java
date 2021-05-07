package com.returnorder.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.returnorder.portal.model.UserDetails;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserDetails, Integer>{

}
