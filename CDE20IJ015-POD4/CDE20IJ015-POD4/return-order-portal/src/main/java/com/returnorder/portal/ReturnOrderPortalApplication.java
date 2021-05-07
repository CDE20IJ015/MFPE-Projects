package com.returnorder.portal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@EntityScan("com.returnorder.portal.model")
@EnableJpaRepositories("com.returnorder.portal.dao")
@SpringBootApplication
@EnableFeignClients
public class ReturnOrderPortalApplication{
	
	static Logger logger = LoggerFactory.getLogger(ReturnOrderPortalApplication.class);


	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean
	public HttpHeaders getHttpHeaders()
	{
		return new HttpHeaders();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ReturnOrderPortalApplication.class, args);
		 logger.info("Web portal started");
	}

}
