package com.flightapp.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.FlightInfo;
import com.flightapp.repository.AirlinsInfoRepo;
import com.flightapp.service.AirlinesService;

@Service
public class AirlinesServiceImpl implements AirlinesService {
	
	@Autowired
	AirlinsInfoRepo airlineRepo;

	@Override
	public List<FlightInfo> findFlights(String from, String to, Date departureDate) {
		// TODO Auto-generated method stub
		return airlineRepo.findFlights(from, to, departureDate);
	}

}
