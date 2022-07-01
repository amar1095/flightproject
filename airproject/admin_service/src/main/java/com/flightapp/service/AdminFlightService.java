package com.flightapp.service;

import java.util.Date;
import java.util.List;

import com.flightapp.entity.FlightDetails;

public interface AdminFlightService {

	public Integer saveFlights(FlightDetails flightDetails);

	public List<FlightDetails> getAllFlights();

	public FlightDetails getFlight(String flightName);

	public FlightDetails getflightNumber(Integer flightNumber);

	void deleteFlightById(Integer flightNumber);

	public Integer updateFlight(FlightDetails addFlight, Integer flightNumber);
//
	public List<Object> findByfromPlaceAndtoPlace(String fromPlace, String toPlace);
//
//	public List<FlightDetails> searchFlight(String fromPlace, String toPlace, Date startDate);
//	
//	

}
