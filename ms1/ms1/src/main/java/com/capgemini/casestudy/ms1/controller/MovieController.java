package com.capgemini.casestudy.ms1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.casestudy.ms1.Movie.Movie;
import com.capgemini.casestudy.ms1.service.MovieCatalogueService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class MovieController {
	
	@Autowired
	private MovieCatalogueService service;
	
	
	@Operation(summary="This mapping is used to view all movies")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully retrived",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error retriving movies",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
	@GetMapping("/viewmovies")
	public List<String> viewAllMovieTitles()
	{
		return service.viewAllMovieTitles();
	}
	
	
	@Operation(summary="This mapping is used to search movie details using movie title")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully retrived",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error retriving movie details",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
	@GetMapping("/searchmovie/{title}")
	public Movie searchMovieDetailsByTitle(@PathVariable("title") String title)
	{
		return service.searchMovieDetailsByTitle(title);
	}
	
	
	
	@Operation(summary="This mapping is used to add movie")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully added the movie",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error Adding the movie ",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
	@PostMapping("/addmovie")
	public void addMovie(@RequestBody Movie movie) 
	{
		service.addMovie(movie);
	}
	
	
	
	@Operation(summary="This mapping is used to update movie details for a paticular movie")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully updated the movie details",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error updating the movie details",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
	@PutMapping("/updatemovie/{title}")
	public void updateMovieDetailsByTitle(@PathVariable("title") String title, @RequestBody Movie movie)
	{
		service.updateMovieDetailsByTitle(title, movie);
	}
	
	
	
	@Operation(summary="This mapping is used to delete a movie")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully deleted the movie",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error deleting the movie",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
	@DeleteMapping("/deletemovie/{title}")
	public void deleteMovieDetailsByTitle(@PathVariable("title") String title)
	{
		service.deleteMovieDetailsByTitle(title);
	}

}