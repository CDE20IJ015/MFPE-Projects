package com.cts.retailproductauthms;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RetailProductAuthMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailProductAuthMsApplication.class, args);
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
		return new ApiInfoBuilder().title("Authentication - API")
				.description("Authentication API reference for frontend Developpers")
				.termsOfServiceUrl("https://www.cognizant.com").contact("pod3@cognizant.com")
				.license("POD-3").licenseUrl("#").version("1.0")
				.build();
	}
}
