package com.ashok.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpringbootSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSwaggerApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		 return new Docket(DocumentationType.SWAGGER_2)
				 .select()
				 .paths(PathSelectors.ant("/contact/*"))
				 .apis(RequestHandlerSelectors.basePackage("com.ashok.learning"))
				 .build()
				 .apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Address Book API",
				"Simple Address book API to enable swagger",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Ashok Maricharla" ,"http://ashok.io" ,"ashok@gmail.com"),
				"API License",
				"http://ashok.io",
				Collections.emptyList()
		);
	}
}
