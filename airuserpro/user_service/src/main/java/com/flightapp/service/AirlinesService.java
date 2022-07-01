package com.flightapp.service;

import java.util.Date;
import java.util.List;

import com.flightapp.entity.FlightInfo;

public interface AirlinesService {
	public List<FlightInfo> findFlights(String from, String to, Date departureDate);

}
