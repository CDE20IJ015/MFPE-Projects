package com.returnorder.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnorder.portal.model.ProcessResponse;

@Repository
public interface ProcessReponseRepository extends JpaRepository<ProcessResponse, Integer> {

}
