package com.capgemini.casestudy.ms1.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.casestudy.ms1.repository.MovieCatalogueRepo;
import com.capgemini.casestudy.ms1.Movie.*;;
@Service
public class MovieCatalogueService {
	
	private List<Movie> list = new ArrayList<Movie>();
	
	@Autowired
	private MovieCatalogueRepo repo;
	
	public List<String> viewAllMovieTitles()
	{
		List<String> list1 = new ArrayList<String>();
		list = repo.findAll();
		
		for(Movie movie : list)
		{
			list1.add(movie.getMovieTitle());
		}
		
		return list1;
		
	}

	public Movie searchMovieDetailsByTitle(String title) {
		Optional<Movie> optional = repo.findById(title);
		if(optional.isPresent())
		{
			Movie movie = optional.get();
			return movie;
		}
		
		return null;
	}

	public void addMovie(Movie movie) {
		repo.save(movie);
	}

	public void updateMovieDetailsByTitle(String title, Movie movie) {
		
		Optional<Movie> optional = repo.findById(title);
		if(optional.isPresent())
		{
			repo.delete(optional.get());
			repo.save(movie);
			
		}
	}

	public void deleteMovieDetailsByTitle(String title) {
		
		Optional<Movie> optional = repo.findById(title);
		if(optional.isPresent())
		{
			repo.deleteById(title);
			
		}
	}

}