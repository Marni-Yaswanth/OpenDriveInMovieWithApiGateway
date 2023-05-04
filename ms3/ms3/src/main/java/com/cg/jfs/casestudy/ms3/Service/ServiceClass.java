package com.cg.jfs.casestudy.ms3.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jfs.casestudy.ms3.Main.MovieDetails;
import com.cg.jfs.casestudy.ms3.Proxy.MovieDetailsProxy;
import com.cg.jfs.casestudy.ms3.Repository.MovieDetailsRepository;


@Service
public class ServiceClass {

	@Autowired
	MovieDetailsRepository repository;
	
	List<MovieDetails> list = new ArrayList<MovieDetails>();
	
	@Autowired
	MovieDetailsProxy proxy;	
	
	public String add(MovieDetails movieDetails) 
	{
		list = repository.findByMovieTitleAndTime(movieDetails.getMovieTitle(),movieDetails.getTime());
		
		
		for (MovieDetails m : list)
		{
			if(movieDetails.getParkingSlots().equals(m.getParkingSlots()))
			{
				return "seat is already there, you cant add it";

			}
			
				
		
		}
		repository.save(movieDetails);
		return "added";
	}

	public List<MovieDetails> addMoviesList(MovieDetails movieDetails) {
		int id = 0;
		List<MovieDetails> lis1 =  proxy.getMovieSchedules();
		
		for(MovieDetails movie:lis1)
		{
			id++;
			movieDetails.setId(id);
			movieDetails.setMovieTitle(movie.getMovieTitle());
			movieDetails.setDate(movie.getDate());
			movieDetails.setTime(movie.getTime());
//			movieDetails.setParkingSlots("A1");
//			movieDetails.setStatus("Available");
			repository.save(movieDetails);
		}
		
		
		return lis1;
	}
}
