package com.returnorder.packagingdelivery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PackagingAndDeliveryApplication {

	static Logger logger = LoggerFactory.getLogger(PackagingAndDeliveryApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PackagingAndDeliveryApplication.class, args);
		logger.info("Packaging and Delivery Module started successfully");
	}

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Public - API").
				apiInfo(apiInfo()).select().paths(myPaths()).build();
	}
	private Predicate<String> myPaths(){
		return PathSelectors.regex("/.*");
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Packaging-Delivery - API")
				.description("Packaging-Delivery API reference for frontend Developpers")
				.termsOfServiceUrl("https://www.cognizant.com").contact("pod4@cognizant.com")
				.license("POD-4").licenseUrl("#").version("1.0")
				.build();
	}
}
