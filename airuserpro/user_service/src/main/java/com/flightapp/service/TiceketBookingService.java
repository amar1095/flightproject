package com.flightapp.service;

import java.util.List;

import com.flightapp.entity.TicketBooking;

public interface TiceketBookingService {
//	Optional<TicketBooking> bookFlight(Integer flightNumber);
//	public TicketBooking bookFlight(TicketBooking bookFlight);
	
	public void cancelBookFlight(Integer id);

	public Integer bookFlight(TicketBooking ticket);

	public List<TicketBooking> getAllBookFlight();
	
	public TicketBooking getFlightByPnr(Long pnrNumber);
	
	public List<TicketBooking> getByEmail(String email);

//	public Optional<TicketBooking> getBookingByPnrNo(Long pnrNumber);

}
