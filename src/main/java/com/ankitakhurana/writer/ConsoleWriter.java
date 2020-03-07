package com.ankitakhurana.writer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.ankitakhurana.entities.Flight;

public class ConsoleWriter {

	public static void print(ArrayList<Flight> filteredFlights, char flightClass) {
		if (filteredFlights == null)
			System.out.println("No flights exist");
		else {
			if (filteredFlights.isEmpty())
				System.out.println("No flight matches your criteria");
			else {
				System.out.println("Total flights found: " + filteredFlights.size());
				System.out.println("------------------------------------------------------------------");
				System.out.printf("%10s %10s %10s %10s %10s %10s", "FLIGHT_NO", "DEP_LOC", "ARR_LOC", "FLIGHT_DUR",
						"FARE", "CLASS");
				System.out.println();
				System.out.println("------------------------------------------------------------------");
				for (Flight flight : filteredFlights) {
					System.out.printf("%10s %10s %10s %10s %10s %10s", flight.getFlightNo(),
							flight.getDepartureLocation(), flight.getArrivalLocation(),
							new SimpleDateFormat("hh:mm").format(flight.getDuration()),
							flightClass == 'B' ? flight.getFare() * 0.40 + flight.getFare() : flight.getFare(),
							flightClass); // Fare price is: Fareprice + 40% of
											// fare price if seatClass
											// is Business class.
					System.out.println();
				}
			}
		}
	}
}
