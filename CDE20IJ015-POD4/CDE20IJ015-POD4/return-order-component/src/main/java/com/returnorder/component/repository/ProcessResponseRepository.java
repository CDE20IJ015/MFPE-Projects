package com.returnorder.component.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnorder.component.model.ProcessResponse;

@Repository
public interface ProcessResponseRepository extends JpaRepository<ProcessResponse, Integer> {
	
}
