package com.cts.retailproductproceedToBuyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories
@EnableSwagger2
public class RetailProductProceedToBuyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailProductProceedToBuyServiceApplication.class, args);
	}

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("ProceedToBuy - API").
				apiInfo(apiInfo()).select().paths(myPaths()).build();
	}
	
	private Predicate<String> myPaths(){
		return PathSelectors.regex("/api/.*");
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Proceed To Buy service - API")
				.description("Proceed To Buy API reference for frontend Developpers")
				.termsOfServiceUrl("https://www.cognizant.com")
				.license("POD - 3")
				.licenseUrl("#")
				.version("1.0")
				.build();
	}
}
