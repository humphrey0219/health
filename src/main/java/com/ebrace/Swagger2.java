package com.ebrace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2 {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ebrace.controller"))
				.paths(PathSelectors.any())
				.build();
	}
//	@Bean
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("aligner的api文档")
				.description("简单优雅的restful风格")
				.termsOfServiceUrl("http://172.18.202.153:2080/aligner")			
				.version("1.0")
				.build();
	}

}
