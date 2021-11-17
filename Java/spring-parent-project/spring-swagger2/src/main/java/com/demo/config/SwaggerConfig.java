package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				//.ignoredParameterTypes(Authentication.class)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.demo.controller"))
				//.paths(PathSelectors.regex("/rest.*"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
	    return new ApiInfo(
	            "TITLE",
	            "DESCIPRION",
	            "VERSION",
	            "TERMS OF SERVICE URL",
	            new Contact("NAME","URL","EMAIL"),
	            "LICENSE",
	            "LICENSE URL"
	    );
	}
}
