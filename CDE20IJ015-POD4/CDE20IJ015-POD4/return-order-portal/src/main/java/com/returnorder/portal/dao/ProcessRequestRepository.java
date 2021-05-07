package com.returnorder.portal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.returnorder.portal.model.ProcessRequest;

@Repository
public interface ProcessRequestRepository extends CrudRepository<ProcessRequest, Integer> {

	
	
}
