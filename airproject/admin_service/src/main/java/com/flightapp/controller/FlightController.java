package com.flightapp.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.FlightDetails;
import com.flightapp.exception.ResourceNotFoundException;
import com.flightapp.service.AdminFlightService;

@RestController
@CrossOrigin("*")
public class FlightController {

	@Autowired
	private AdminFlightService flightServiceImpl;

//	Creating a post method for adding a flight to our my sql database
	@GetMapping("/login")
	public String login() {
		
		return "Authentication is Successful";
	}

	@PostMapping("/addFlight")
	public ResponseEntity<String> addFlight(@RequestBody FlightDetails addFlight) throws IOException {

		ResponseEntity<String> resp = null;
		try {

			Integer flightNumber = flightServiceImpl.saveFlights(addFlight);
			System.out.println("flight data :  " + addFlight);
			resp = new ResponseEntity<String>(
					new StringBuffer().append("Flight added with flightNumber ").append(flightNumber).toString(),
					HttpStatus.CREATED);

		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to process addFlight", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}

	@GetMapping("/searchAllFlights")
	public ResponseEntity<List<FlightDetails>> getAllFlight() {
		ResponseEntity<List<FlightDetails>> resp = null;
		try {
			List<FlightDetails> list = flightServiceImpl.getAllFlights();
			resp = new ResponseEntity<List<FlightDetails>>(list, HttpStatus.OK);

		} catch (Exception e) {
			resp = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/getFlightsByNumber/{flightNumber}")
	public ResponseEntity<?> getFlightByNumber(@PathVariable("flightNumber") Integer flightNumber) {
		ResponseEntity<?> resp = null;
		try {
			FlightDetails flightByNumber = flightServiceImpl.getflightNumber(flightNumber);
			resp = new ResponseEntity<FlightDetails>(flightByNumber, HttpStatus.OK);

		}

		catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to fetch flight with Number " + flightNumber,
					HttpStatus.NOT_FOUND);
			e.printStackTrace();
		}
		return resp;

	}

	@DeleteMapping("/deleteFlight/{flightNumber}")
	public ResponseEntity<?> deleteFlight(@PathVariable("flightNumber") Integer flightNumber) {

		ResponseEntity<?> resp = null;
		try {

			flightServiceImpl.deleteFlightById(flightNumber);
			Map<String, Boolean> response = new HashMap<>();
			response.put("Flight is Deleted with flightNumber" + flightNumber, Boolean.TRUE);
			resp = ResponseEntity.ok(response);

		} catch (Exception e) {

			resp = new ResponseEntity<String>(" Flight not present with  this flightNumber  " + flightNumber,
					HttpStatus.NOT_FOUND);
			e.printStackTrace();
		}
		return resp;
	}

	@PutMapping("/updateFlight/{flightNumber}")
	public ResponseEntity<?> updateFlight(@PathVariable("flightNumber") Integer flightNumber,
			@RequestBody FlightDetails addFlight) {

		ResponseEntity<?> resp = null;

		System.out.println("Flight number is..." + flightNumber);
		System.out.println(addFlight);
		try {
			Integer updateFlight = flightServiceImpl.updateFlight(addFlight, flightNumber);
			resp = new ResponseEntity<FlightDetails>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(" Flight record not exist with flightNumber " + flightNumber,
					HttpStatus.NOT_FOUND);
		}
		return resp;
	}



	@GetMapping("/search/{fromPlace}/{toPlace}")
	public List<Object> findByfromPlaceAndtoPlace(@PathVariable("fromPlace") String fromPlace,
			@PathVariable("toPlace") String toPlace) {
		List<Object> fromPlaceAndtoPlace = null;

		try {
			if (fromPlace != null && toPlace != null) {
				fromPlaceAndtoPlace = flightServiceImpl.findByfromPlaceAndtoPlace(fromPlace, toPlace);
				if (fromPlaceAndtoPlace.size() == 0) {
					throw new ResourceNotFoundException(
							"Unable to fetch resource from " + fromPlace + " toPlace " + toPlace);
				}
				System.out.println(fromPlaceAndtoPlace);

				return fromPlaceAndtoPlace;
			} else {
				throw new ResourceNotFoundException(
						"Unable to fetch resource from " + fromPlace + " toPlace " + toPlace);
			}

		} catch (Exception e) {
			e.printStackTrace();

			throw new ResourceNotFoundException("Unable to fetch resource from " + fromPlace + " toPlace " + toPlace);

		}

	}

	@GetMapping("/flightsByName/{flightName}")

	public ResponseEntity<?> getFlightByName(@PathVariable("flightName") String flightName) {

		ResponseEntity<?> resp = null;

		try {
			FlightDetails name = flightServiceImpl.getFlight(flightName);
			resp = new ResponseEntity<FlightDetails>(name, HttpStatus.OK);

		}

		catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to fetch flight with name " + flightName, HttpStatus.NOT_FOUND);
			e.printStackTrace();
		}
		return resp;

	}
	
	
	
}
