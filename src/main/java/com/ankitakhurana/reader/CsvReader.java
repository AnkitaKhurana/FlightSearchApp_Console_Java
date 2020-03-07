package com.ankitakhurana.reader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import com.ankitakhurana.dtos.FlightDTO;
import com.ankitakhurana.entities.Flight;
import com.ankitakhurana.entities.FlightClassType;
import com.opencsv.CSVReader;

public class CsvReader implements IReader {

	private ArrayList<String> filesSeen = new ArrayList<String>();

	public void read(FlightDTO DTO,String directory) {

		ArrayList<String> allFilesInDir = new ArrayList<>();
		try (Stream<Path> filePathStream = Files.walk(Paths.get(directory))) {
			filePathStream.forEach(filePath -> {
				if (Files.isRegularFile(filePath) && filePath.toString().endsWith(".csv")) {
					allFilesInDir.add((filePath.toString()));
				}
			});
			for (String file : allFilesInDir) {
				if (!filesSeen.contains(file)) {
					filesSeen.add(file);
					FileReader freader = new FileReader(file);
					CSVReader reader = new CSVReader(freader, '|', '"', 1);
					// separator in values in csv files and start extracting
					// column from 2nd ow
					List<String[]> records = reader.readAll();
					Iterator<String[]> iterator = records.iterator();

					while (iterator.hasNext()) {
						Flight flightObj = new Flight();
						String[] flightDetails = iterator.next();

						flightObj.setFlightNo(flightDetails[0]);
						flightObj.setDepartureLocation(flightDetails[1]);
						flightObj.setArrivalLocation(flightDetails[2]);
						flightObj.setValidTill(new SimpleDateFormat("dd-MM-yyyy").parse(flightDetails[3]));
						flightObj.setFlightTime(new SimpleDateFormat("hhmm").parse(flightDetails[4]));
						flightObj.setDuration(new SimpleDateFormat("hh.mm").parse(flightDetails[5]));
						flightObj.setFare(Float.parseFloat(flightDetails[6]));
						flightObj.setSeatAvailable(flightDetails[7].equals("Y"));
						flightObj.setFlightClass(FlightClassType.valueOf(flightDetails[8]));

						DTO.add(flightObj);
					}
					reader.close();
				}
			}
		} catch (IOException | ParseException e) {
			System.out.println(e.getMessage().toString());
		}

	}

}
