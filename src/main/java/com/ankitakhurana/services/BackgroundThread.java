package com.ankitakhurana.services;

import java.io.IOException;
import java.text.ParseException;

import com.ankitakhurana.constants.*;
import com.ankitakhurana.services.FlightService;

public class BackgroundThread extends Thread {
	FlightService service;
	Watcher watcher;

	public BackgroundThread(FlightService s) {
		this.service = s;
	}

	@Override
	public void run() {
		try {
			service.populate(FlightConstants.DIRECTORY);
			watcher = new Watcher(FlightConstants.DIRECTORY);
			watcher.startWatching();
		} catch (NumberFormatException | IOException | ParseException e) {
			System.out.println("Error: " + e.toString());
		}

	}

	public void stopThread() {
		watcher.stopWatching();
	}

}
