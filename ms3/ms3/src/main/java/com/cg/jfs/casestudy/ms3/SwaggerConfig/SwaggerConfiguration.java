package com.cg.jfs.casestudy.ms3.SwaggerConfig;

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
				.title("Movie Booking Microservice")
				.version("1.0V")
				.description("Movie Booking (microservice)  View Parking Slot Availability  Book Ticket  View Booking Details  Cancel Booking ")
				.termsOfService("http://swagger.io/terms/"));
	}
		
}
