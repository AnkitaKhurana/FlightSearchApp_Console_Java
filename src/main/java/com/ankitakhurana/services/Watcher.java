package com.ankitakhurana.services;

import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.ParseException;
import java.util.List;

public class Watcher {

	String directoryPath;
	WatchService watcher;

	public Watcher() {
		this.directoryPath = "";
	}

	public Watcher(String path) {
		this.directoryPath = path;
	}

	public void startWatching() {

		try {
			final Path dir = Paths.get(directoryPath);
			WatchKey watckKey = null;

			do {
				watcher = dir.getFileSystem().newWatchService();
				dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
						StandardWatchEventKinds.ENTRY_MODIFY);

				watckKey = watcher.take();

				List<WatchEvent<?>> events = watckKey.pollEvents();
				for (@SuppressWarnings("rawtypes")
				WatchEvent event : events) {
					if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
						FlightService.getInstance().populate(this.directoryPath);

					}
					if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
						System.out.println("Delete: " + event.context().toString());
						FlightService.getInstance().populate(this.directoryPath);

					}
					if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
						System.out.println("Modify: " + event.context().toString());
						FlightService.getInstance().populate(this.directoryPath);

					}
				}
			} while (watckKey.reset());

		} catch (ClosedWatchServiceException | IOException | InterruptedException | NumberFormatException
				| ParseException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			this.stopWatching();
		}
	}

	public void stopWatching() {
		try {
			watcher.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}
}
