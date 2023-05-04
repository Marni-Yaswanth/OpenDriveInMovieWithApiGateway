package com.cg.jfs.casestudy.ms3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jfs.casestudy.ms3.Main.MovieDetails;
import com.cg.jfs.casestudy.ms3.Service.ServiceClass;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
public class MovieDetailsController {

	@Autowired
	ServiceClass serviceClass;
	
	
	@Operation(summary="This mapping is used to add parking slot")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully added the slot",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error adding slot",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
	@PostMapping("/add")
	public String addParking(@RequestBody MovieDetails movieDetails) 
	{
		return serviceClass.add(movieDetails);
	}
	
	
	@Operation(summary="This mapping is used to view all the movies and their schedules")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully retrived movie schedules",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error retriving movie schedules",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
	@PostMapping("/addlist")
	public List<MovieDetails> addMoviesList(@RequestBody MovieDetails movieDetails)
	{
		 return serviceClass.addMoviesList(movieDetails);
	}
}
