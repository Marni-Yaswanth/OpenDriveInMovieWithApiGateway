package com.cg.casestudy.ms2.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.casestudy.ms2.Movie.Movie1;
import com.cg.casestudy.ms2.exception.InvalidMovieFound;
import com.cg.casestudy.ms2.proxy.MovieScheduleProxy;
import com.cg.casestudy.ms2.repository.MovieScheduleRepository;

@Service
public class MovieScheduleService {
	
	@Autowired
    private MovieScheduleRepository movieScheduleRepository;
	
	
	@Autowired
	MovieScheduleProxy proxy;
	
	List<String> list = new ArrayList<String>();
	
	public String addMovieSchedule(Movie1 movie1) throws InvalidMovieFound, ParseException{
	
		list = proxy.viewAllMovieTitles();
		
		if(list.contains(movie1.getMovieTitle())) 
		{
			if (movie1.checkDate(movie1.getDate())) 
			{
				movieScheduleRepository.save(movie1);
				return "successfully scheduled";
			}
			return  "Invalid Date";
		}
		else 
		{

			throw new InvalidMovieFound("No Such movie found");
		}
			
	}    

    public String updateMovieSchedule(String title, Movie1 movie1) throws InvalidMovieFound {
    	list = proxy.viewAllMovieTitles();
    	Optional<Movie1> optional = movieScheduleRepository.findById(title);
    	if(optional.isPresent()) 
		{
    		movieScheduleRepository.delete(optional.get());
    		movieScheduleRepository.save(movie1);
    		return "successfully updated";
		}
    	else {
    		throw new InvalidMovieFound("no movie found to update");
		}
    	
    }

	public Movie1 getMovieSchedule(String title) {
		
		Optional<Movie1> optionalMovieSchedule = movieScheduleRepository.findById(title);
		if(optionalMovieSchedule.isPresent())
		{
			return optionalMovieSchedule.get();
		}
		return null;
	}

	public String deleteMovieSchedule(String title) throws InvalidMovieFound {
		Optional<Movie1> optional = movieScheduleRepository.findById(title);
		if(optional.isPresent())
		{
			movieScheduleRepository.delete(optional.get());
			return "deleted successfully";
		}
		else {
			throw new InvalidMovieFound("no movie found to delete");
		}
		
	}

	public List<Movie1> getMovieSchedules() {
		
		List<Movie1> list2 = movieScheduleRepository.findAll();
		return list2;
	
	}
}
