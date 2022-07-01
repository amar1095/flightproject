package com.flightapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.FlightInfo;
import com.flightapp.service.AirlinesService;

@RestController
public class AirlinesController {

	@Autowired
	private AirlinesService airlineService;

	@GetMapping("/findFlight")
	public List<FlightInfo> findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "dd-mm-yyyy") Date departureDate) {

		return airlineService.findFlights(from, to, departureDate);

	}

}
