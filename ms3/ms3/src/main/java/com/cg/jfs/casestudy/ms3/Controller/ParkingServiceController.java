package com.cg.jfs.casestudy.ms3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jfs.casestudy.ms3.InvalidSeatException;
import com.cg.jfs.casestudy.ms3.Main.ParkingDetailsClass;
import com.cg.jfs.casestudy.ms3.Service.ParkingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
public class ParkingServiceController {
	@Autowired
	ParkingService parkingService;

	
	@Operation(summary="This mapping is used to check slots for a particular movie at a particular time")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully retrived slots",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error retriving slots",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
	@GetMapping("/checkSlots/{movieTitle}/{time}")
	public List<String> checkSlots(@PathVariable("movieTitle")String movieTitle,@PathVariable("time")String time)
	{
		return parkingService.checkSlots(movieTitle,time);
	}
	
	
	@Operation(summary="This mapping is used to book ticket by proving client's information")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully added clients information",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error adding clients information",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
	@PostMapping("/addDetails")
	public String add(@RequestBody ParkingDetailsClass parkingDetailsClass) throws InvalidSeatException
	{
		 return  parkingService.addDetails(parkingDetailsClass);
	}
	
	
	@Operation(summary="This mapping is used to cancel ticket for a particular movie")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Successfully cancelled the ticket",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",description = "Error cancelling the ticket",content = @Content),
			@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
	})
	@DeleteMapping("/cancel/{id}")
	public String cancelTicket(@PathVariable("id")String id) throws InvalidSeatException
	{
		return parkingService.cancelTicket(id);
	}
	
	@ExceptionHandler(InvalidSeatException.class)
	public String handleException(InvalidSeatException ex) 
	{
		return ex.getMessage();
	}
}
