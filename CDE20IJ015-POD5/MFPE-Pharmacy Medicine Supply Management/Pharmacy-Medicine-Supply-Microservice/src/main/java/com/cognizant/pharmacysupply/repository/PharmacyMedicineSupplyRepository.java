package com.cognizant.pharmacysupply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.pharmacysupply.model.PharmacyMedicineSupply;
/**
 * This is the repository interface for medicine supply which is using JpaRepository.
 */
@Repository
public interface PharmacyMedicineSupplyRepository extends JpaRepository<PharmacyMedicineSupply, Integer>{

}
