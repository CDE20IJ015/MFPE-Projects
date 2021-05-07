package com.cognizant.portfoliomanagement.WebPortal.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.portfoliomanagement.WebPortal.Model.ShareDetails;




@FeignClient(name="ShareDetailsService",url="http://cde15pod1share.eba-99pczyrp.ap-south-1.elasticbeanstalk.com")
public interface ShareDetailsFiegnProxy {
	
	@GetMapping("/dailyAllSharePrice")
	public List<ShareDetails> getAllDailySharePrice(@RequestHeader("Authorization") String token);
	
	}