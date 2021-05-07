package com.cognizant.portfoliomanagement.WebPortal.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.portfoliomanagement.WebPortal.Model.MutualFund;



@FeignClient(name="DailyMutualFundService",url="http://cde15pod1mutual.eba-99pczyrp.ap-south-1.elasticbeanstalk.com")
public interface MutualFundDetailsFeignProxy {
	
	@GetMapping("/dailyAllMutualFundNav")
	public List<MutualFund> getAllMututalFunds(@RequestHeader("Authorization") String token);
	
	@GetMapping("/dailyMutualFundNav/name/{mutualFundName}")
	public MutualFund getMutualDetails(@RequestHeader("Authorization") String token,@PathVariable(value="mutualFundName") String mutualFundName);
	
	@GetMapping("/dailyMutualFundNav/{mutualFundIdList}")
	public List<Double> getMutualDetailsById(@RequestHeader("Authorization") String token,@PathVariable(value="mutualFundIdList") List<String> mutualFundId);

}
