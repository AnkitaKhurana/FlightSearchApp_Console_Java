package com.ankitakhurana.validations;

import java.util.InputMismatchException;

import com.ankitakhurana.entities.FlightClassType;

public class UserInputValidator {

	public static boolean validateLocationCode(String source) {
		if (source.matches("[a-zA-Z]{3}"))
			return true;
		else
			System.out.println("Invalid location code.");
		return false;
	}

	public static boolean validateClass(String flightClass) {
		try {
			FlightClassType.valueOf(flightClass.toUpperCase());
			return true;

		} catch (Exception e) {
			System.out.println("Invalid flight class");
			return false;

		}
	}

	public static boolean validatorOrderPreferance(String value) {
		try {
			int orderPreferance = Integer.parseInt(value);
			if (orderPreferance == 1 || orderPreferance == 2)
				return true;
			else {
				System.out.println("Invalid orderPreferance");
				return false;
			}
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("Invalid order Preferance");
			return false;
		}

	}

}
