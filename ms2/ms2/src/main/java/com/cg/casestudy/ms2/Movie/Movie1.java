package com.cg.casestudy.ms2.Movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie1 {
	@Id
	private String movieTitle;
	private String date;
	private String time;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	
	public String getMovieTitle() {
		return movieTitle;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Movie1(String movieTitle, String date, String time) {
		super();
		this.movieTitle = movieTitle;
		this.date = date;
		this.time = time;

	}
	
	
	public Boolean checkDate(String date) throws ParseException
	{
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = sdf.parse(date);
			LocalDate date2 = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			String date3 = date2.format(formatter);
			Date date4 = sdf.parse(date3);
			if (date4.before(date1)||date4.equals(date1)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {

		}
		return false;
	}

	

	public Movie1()
	{
		
	}

}
