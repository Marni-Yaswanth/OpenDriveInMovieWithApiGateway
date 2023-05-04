package com.cg.jfs.casestudy.ms3.Main;

import jakarta.persistence.*;

@Entity
public class ParkingDetailsClass {

	@Id
	private String carNumber;
	private String movieTitle;
	private String date;
	private String playTime;
	private String parkingSlotNumber;
	private String confirmationId;
	private double price;
	public ParkingDetailsClass(String carNumber, String movieTitle, String date, String playTime,
			String parkingSlotNumber) {
		super();
		this.carNumber = carNumber;
		this.movieTitle = movieTitle;
		this.date = date;
		this.playTime = playTime;
		this.parkingSlotNumber = parkingSlotNumber;
//		this.confirmationId = confirmationId;
	}

	public ParkingDetailsClass() {
		super();
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
	public String getParkingSlotNumber() {
		return parkingSlotNumber;
	}
	public void setParkingSlotNumber(String parkingSlotNumber) {
		this.parkingSlotNumber = parkingSlotNumber;
	}
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	
	
	
}
