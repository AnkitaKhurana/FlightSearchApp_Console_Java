package com.ankitakhurana.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.ankitakhurana.entities.UserInput;
import com.ankitakhurana.reader.ConsoleReader;
import com.ankitakhurana.services.BackgroundThread;
import com.ankitakhurana.entities.Flight;
import com.ankitakhurana.services.FlightService;
import com.ankitakhurana.writer.ConsoleWriter;

public class MainApplication {

	public static void main(String[] args) {

		try {
			FlightService service = FlightService.getInstance();
			BackgroundThread backgroundThread = new BackgroundThread(service);
			backgroundThread.start();
			while (true) {
				System.out.println("Do you want to search flights?...\n Enter [Y]es or [N]o");

				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				String progContinue = sc.next().toUpperCase();
				if (progContinue.equals("N") || progContinue.equals("NO"))
					break;

				ConsoleReader consoleReader = new ConsoleReader();
				UserInput query = consoleReader.getInputs();

				ArrayList<Flight> flightsOfInterest = service.findFlights(query);
				ConsoleWriter.print(flightsOfInterest, query.getSeatClass().toString().charAt(0));

			}
			backgroundThread.stopThread();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
