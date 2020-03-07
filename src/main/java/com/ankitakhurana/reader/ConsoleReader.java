package com.ankitakhurana.reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.ankitakhurana.entities.FlightClassType;
import com.ankitakhurana.entities.UserInput;
import com.ankitakhurana.validations.UserInputValidator;

public class ConsoleReader {
	Scanner sc = new Scanner(System.in);

	public UserInput getInputs() {
		UserInput query = new UserInput();
		query.setSource(getSource());
		query.setDestination(getDestination());
		query.setFlightDate(getFlightDate());
		query.setSeatClass(getSeatClass());
		query.setSearchOrderPreferance(getOrderPreferance());
		return query;
	}

	private String getSource() {
		while (true) {
			System.out.println("Enter departure location: (Use 3 letter location code)");
			String source = sc.next();
			if (UserInputValidator.validateLocationCode(source)) {
				return source.toUpperCase();
			}
		}
	}

	private String getDestination() {
		while (true) {
			System.out.println("Enter departure location: (Use 3 letter location code)");
			String source = sc.next();
			if (UserInputValidator.validateLocationCode(source)) {
				return source.toUpperCase();
			}
		}
	}

	private Date getFlightDate() {
		while (true) {
			System.out.println("Enter flight date in format: dd-mm-yyyy");
			String flightDate = sc.next();
			try {
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				format.setLenient(false);
				return (format.parse(flightDate));
			} catch (ParseException e) {
				System.out.println("Invalid date.");
			}
		}
	}

	private FlightClassType getSeatClass() {
		while (true) {
			System.out.println("Enter flight class (E for economic class and  B for business class): ");
			String flightClass = sc.next();
			if (UserInputValidator.validateClass(flightClass)) {
				return FlightClassType.valueOf(flightClass.toUpperCase());
			}
		}
	}

	private int getOrderPreferance() {
		while (true) {
			System.out.println("Enter flight order preferance\n  (Enter 1 for fare, 2 for fare and flight duration): ");
			String orderPreferance = sc.next();
			if (UserInputValidator.validatorOrderPreferance(orderPreferance))
				return Integer.parseInt(orderPreferance);
		}
	}

}
