package com.cognizant.pharmacysupply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.pharmacysupply.model.MedicineDemand;
/**
 * This is the repository interface for medicine demand which is using JpaRepository.
 */
@Repository
public interface MedicineDemandRepository extends JpaRepository<MedicineDemand, Integer>{

}
