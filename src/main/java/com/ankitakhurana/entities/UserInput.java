package com.ankitakhurana.entities;

import java.util.Date;

public class UserInput {
	private String source;
	private String destination;
	private Date flightDate;
	private FlightClassType seatClass;
	private int searchOrderPreferance;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public FlightClassType getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(FlightClassType seatClass) {
		this.seatClass = seatClass;
	}

	public int getSearchOrderPreferance() {
		return searchOrderPreferance;
	}

	public void setSearchOrderPreferance(int searchOrderPreferance) {
		this.searchOrderPreferance = searchOrderPreferance;
	}

}
