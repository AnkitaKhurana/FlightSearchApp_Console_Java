package com.ankitakhurana.entities;

import java.util.Date;

public class Flight {
	private String flightNo;
	private String departureLocation;
	private String arrivalLocation;
	private Date validTill;
	private Date flightTime;
	private Date duration;
	private float fare;
	private boolean seatAvailable;
	private FlightClassType flightClass;

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public Date getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Date flightTime) {
		this.flightTime = flightTime;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	public boolean isSeatAvailable() {
		return seatAvailable;
	}

	public void setSeatAvailable(boolean seatAvailable) {
		this.seatAvailable = seatAvailable;
	}

	public FlightClassType getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(FlightClassType flightClass) {
		this.flightClass = flightClass;
	}
}
