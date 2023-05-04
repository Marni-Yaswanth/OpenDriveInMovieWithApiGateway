package com.capgemini.casestudy.ms1.Movie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {
	@Id
	private String movieTitle;
	private String description;
	private String genre;
	private double imdb_rating;
	
	public Movie()
	{
		
	}

	public Movie(String movieTitle, String description, String genre, double imdb_rating) {
		super();
		this.movieTitle = movieTitle;
		this.description = description;
		this.genre = genre;
		this.imdb_rating = imdb_rating;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getImdb_rating() {
		return imdb_rating;
	}

	public void setImdb_rating(double imdb_rating) {
		this.imdb_rating = imdb_rating;
	}
	
	
	
}