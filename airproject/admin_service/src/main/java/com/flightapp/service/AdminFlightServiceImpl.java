package com.flightapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.FlightDetails;
import com.flightapp.exception.ResourceNotFoundException;
import com.flightapp.repository.FlightRepository;

@Service
public class AdminFlightServiceImpl implements AdminFlightService {

	@Autowired
	FlightRepository flightRepo;

	@Override
	public Integer saveFlights(FlightDetails flightDetails) {
		FlightDetails flighDetails = flightRepo.save(flightDetails);
		return flighDetails.getFlightNumber();
	}

	@Override
	public List<FlightDetails> getAllFlights() {
		// TODO Auto-generated method stub
		return flightRepo.findAll();
	}

	@Override
	public FlightDetails getflightNumber(Integer flightNumber) {
		// TODO Auto-generated method stub
		return flightRepo.findByFlightNumber(flightNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Flight Name not found.."));
	}

	@Override
	public void deleteFlightById(Integer flightNumber) {

		FlightDetails existingflightNumber = getflightNumber(flightNumber);

		flightRepo.delete(existingflightNumber);
	}

	@Override
	public Integer updateFlight(FlightDetails addFlight, Integer flightNumber) {
		FlightDetails existingFlight = getflightNumber(flightNumber);
		existingFlight.setId(addFlight.getId() != null ? addFlight.getId() : existingFlight.getId());
		existingFlight.setFlightNumber(
				addFlight.getFlightNumber() != null ? addFlight.getFlightNumber() : existingFlight.getFlightNumber());
		existingFlight.setOperatingAirlines(addFlight.getOperatingAirlines() != null ? addFlight.getOperatingAirlines()
				: existingFlight.getOperatingAirlines());

		existingFlight.setFromPlace(
				addFlight.getFromPlace() != null ? addFlight.getFromPlace() : existingFlight.getFromPlace());
		existingFlight
				.setToPlace(addFlight.getToPlace() != null ? addFlight.getToPlace() : existingFlight.getToPlace());
		existingFlight.setStartDate(
				addFlight.getStartDate() != null ? addFlight.getStartDate() : existingFlight.getStartDate());
		existingFlight
				.setEndDate(addFlight.getEndDate() != null ? addFlight.getEndDate() : existingFlight.getEndDate());
		existingFlight.setScheduleDays(
				addFlight.getScheduleDays() != null ? addFlight.getScheduleDays() : existingFlight.getScheduleDays());
		existingFlight.setBusinessSeats(addFlight.getBusinessSeats() != null ? addFlight.getBusinessSeats()
				: existingFlight.getBusinessSeats());
		existingFlight.setNonBusinessSeats(addFlight.getNonBusinessSeats() != null ? addFlight.getNonBusinessSeats()
				: existingFlight.getNonBusinessSeats());
		existingFlight.setCost(addFlight.getCost() != null ? addFlight.getCost() : existingFlight.getCost());
		existingFlight.setDateOfDeparture(addFlight.getDateOfDeparture() != null ? addFlight.getDateOfDeparture()
				: existingFlight.getDateOfDeparture());
		flightRepo.save(existingFlight);

		return existingFlight.getFlightNumber();

	}

	@Override
	public List<Object> findByfromPlaceAndtoPlace(String fromPlace, String toPlace) {
		// TODO Auto-generated method stub
		return flightRepo.findByFromPlaceAndToPlace(fromPlace, toPlace);
	}
//
//	@Override
//	public List<FlightDetails> searchFlight(String fromPlace, String toPlace, Date startDate) {
//		return flightRepo.searchFlight(fromPlace, toPlace, startDate);
//	}
//
	@Override
	public FlightDetails getFlight(String flightName) {

		return flightRepo.findByOperatingAirlines(flightName)
				.orElseThrow(() -> new ResourceNotFoundException("flightName not found"));

	}

}
