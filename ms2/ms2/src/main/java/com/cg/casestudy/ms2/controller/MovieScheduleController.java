package com.cg.casestudy.ms2.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.casestudy.ms2.Movie.Movie1;
import com.cg.casestudy.ms2.exception.InvalidMovieFound;
import com.cg.casestudy.ms2.service.MovieScheduleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class MovieScheduleController {

    @Autowired
    private MovieScheduleService movieScheduleService;

    
    @Operation(summary="This mapping is used to add movie schedule to a particular movie")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully added movie schedule",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error adding movie schedule",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
    @PostMapping("/add")
    public String addMovieSchedule1(@RequestBody Movie1 movie1) throws InvalidMovieFound, ParseException {
        return movieScheduleService.addMovieSchedule(movie1);
    }


  
    @Operation(summary="This mapping is used to update the movie schedule")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully updated ",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error updating movies",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
    @PutMapping("/update/{title}")
    public String updateMovieSchedule(@PathVariable("title") String title, 
                                                       @RequestBody Movie1 movie1)throws InvalidMovieFound {
    	return movieScheduleService.updateMovieSchedule(title, movie1); 
    }

    
    @Operation(summary="This mapping is used to retrive schedule for a particular movie")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully retrived",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error retriving movie schedule",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
    @GetMapping("/get/{title}")
    public Movie1 getMovieSchedule(@PathVariable("title")  String title) {
        return movieScheduleService.getMovieSchedule(title);
    }

    
    
    @Operation(summary="This mapping is used to delete movie schedule for a particular movie")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully deleted",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error deleting movie schedule",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
    @DeleteMapping("/delete/{title}")
    public String removeMovieSchedule(@PathVariable("title") String title) throws InvalidMovieFound{
        return movieScheduleService.deleteMovieSchedule(title);
       
    }
    
    
    @Operation(summary="This mapping is used to retrive all the movies with schedules")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully retrived",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error retriving movie list",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
    @GetMapping("/getdetails")
    public List<Movie1> getMovieSchedules() {
        return movieScheduleService.getMovieSchedules();
    }
    
    
    
	@ExceptionHandler(InvalidMovieFound.class)
	public String handleException(InvalidMovieFound ex) 
	{
		return ex.getMessage();
	}
    
   
}