package com.cts.retailproductvendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.retailproductvendor.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
