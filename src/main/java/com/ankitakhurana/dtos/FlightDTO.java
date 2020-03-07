package com.ankitakhurana.dtos;

import java.util.ArrayList;
import java.util.HashMap;

import com.ankitakhurana.entities.Flight;

public class FlightDTO {

	private HashMap<String, ArrayList<Flight>> dto;

	public FlightDTO() {
		dto = new HashMap<>();
	}
	
	public ArrayList <Flight> findFlights(String source, String destination) {
		String Searchpair = source + "|" + destination;
		ArrayList<Flight> allFlights = dto.get(Searchpair);
		return allFlights;
	}

	public void add(Flight flight) {
		String pair = flight.getDepartureLocation() + flight.getArrivalLocation();
		ArrayList <Flight> flights = dto.get(pair);
		if (flights == null) {
			flights = new ArrayList<>();
		}
		flights.add(flight);
		dto.put(pair, flights);
	}
}
