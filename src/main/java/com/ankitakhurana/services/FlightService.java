package com.ankitakhurana.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.ankitakhurana.dtos.FlightDTO;
import com.ankitakhurana.entities.Flight;
import com.ankitakhurana.entities.UserInput;
import com.ankitakhurana.reader.CsvReader;
// make final class for singleton
public final class FlightService {

	private static FlightService flightService ;
	private FlightDTO DTO;
	private CsvReader reader;

	private FlightService() {
		this.DTO = new FlightDTO();
		this.reader = new CsvReader();
	}
	
	public void populate(String filesDirectory) throws NumberFormatException, IOException, ParseException {
		reader.read(DTO, filesDirectory);
	}

	public static FlightService getInstance() {
		if (flightService == null)
			flightService = new FlightService();
		return flightService;
	}

	public ArrayList<Flight> findFlights(UserInput query) {
		ArrayList<Flight> allFlights = DTO.findFlights(query.getSource(), query.getDestination());
		// all flights from the source to destination.

		ArrayList<Flight> validFlights = new ArrayList<>();
		if (allFlights == null) // no flights between given source and
								// destination.
			return validFlights;

		validFlights = (ArrayList<Flight>) allFlights.stream()
				.filter(flight -> flight.isSeatAvailable() && !query.getFlightDate().after(flight.getValidTill())
						&& flight.getFlightClass().toString().contains(query.getSeatClass().toString()))
				.collect(Collectors.toList());  // filtering out the flights
												// which doesn't satisfy user
												// criteria.

		if (query.getSearchOrderPreferance() == 1) // sort by fare only
			Collections.sort(validFlights, Comparator.comparing(Flight::getFare));
		else // sort by fare as well as duration of the flight.
			Collections.sort(validFlights, Comparator.comparing(Flight::getFare).thenComparing(Flight::getDuration));
		return validFlights;
	}

}
