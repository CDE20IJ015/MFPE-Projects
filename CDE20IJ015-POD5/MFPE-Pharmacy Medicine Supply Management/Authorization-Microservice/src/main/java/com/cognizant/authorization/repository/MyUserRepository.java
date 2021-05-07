package com.cognizant.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.authorization.model.MyUser;

/**
 * This is the repository interface which is using JpaRepository.
 */
@Repository
public interface MyUserRepository extends JpaRepository<MyUser, String> {

	
}
