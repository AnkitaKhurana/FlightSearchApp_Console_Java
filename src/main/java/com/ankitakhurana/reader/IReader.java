package com.ankitakhurana.reader;

import com.ankitakhurana.dtos.FlightDTO;

@FunctionalInterface
public interface IReader {

	void read(FlightDTO DTO, String directory);

}
