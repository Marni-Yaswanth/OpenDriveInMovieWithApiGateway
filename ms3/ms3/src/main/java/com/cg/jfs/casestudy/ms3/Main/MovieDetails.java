package com.cg.jfs.casestudy.ms3.Main;


import jakarta.persistence.*;

@Entity
public class MovieDetails {

	
	@Id
//	@GeneratedValue()
	private int id;
	private String movieTitle;
	private String time;
	private String date;
	private String parkingSlots;
	private String status;
	
	public MovieDetails(int id, String movieTitle, String time, String date, String parkingSlots, String status) {
		super();
		this.id = id;
		this.movieTitle = movieTitle;
		this.time = time;
		this.date = date;
		this.parkingSlots = parkingSlots;
		this.status = status;
	}
	public MovieDetails() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getParkingSlots() {
		return parkingSlots;
	}
	public void setParkingSlots(String parkingSlots) {
		this.parkingSlots = parkingSlots;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
