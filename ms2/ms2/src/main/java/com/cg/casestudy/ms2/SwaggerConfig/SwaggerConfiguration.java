package com.cg.casestudy.ms2.SwaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration 
{
	@Bean
	public OpenAPI customOpenAPI()
	{
		return new OpenAPI()
				.info(new Info()
				.title("Movie Schedule Microservice")
				.version("1.0V")
				.description("Movie Schedule (microservice)  Add Date for a particular Movie   Add moive timings")
				.termsOfService("http://swagger.io/terms/"));
	}
		
}
