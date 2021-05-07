package com.cognizant.medicalrepresentativeschedule.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
/*
 * This Feign Client connects to medicine-stock-service present at port 8091
 */

@FeignClient(url = "http://172.31.35.239:8091", name = "medicine-stock-service")
public interface MedicineStockFeignClient {

	@PostMapping("/api/medicine-stock/byTreatingAilment/{treatingAilment}")
	public String[] getMedicinesByTreatingAilment(@RequestHeader("Authorization") String token, @PathVariable("treatingAilment") String treatingAilment);

}
