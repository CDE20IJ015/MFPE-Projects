package com.cognizant.calculateNetworth.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.calculateNetworth.model.StockDetails;

@FeignClient(name="ShareDetailsService",url="http://cde15pod1share.eba-99pczyrp.ap-south-1.elasticbeanstalk.com")
public interface ShareDetailsFiegnProxy {
	
	@GetMapping("/dailyAllSharePrice")
	public List<StockDetails> findAll(@RequestHeader("Authorization") String token);
	
	@GetMapping("/dailySharePrice/name/{shareName}")
	public StockDetails finddailyShareByName(@RequestHeader("Authorization") String token,@PathVariable(value="shareName") String shareName);
	
	@GetMapping("/dailySharePrice/{shareIdList}")
	public List<Double> finddailyShareById(@RequestHeader("Authorization") String token,@PathVariable(value="shareIdList")List<String> shareIdList);
}

