package com.flightapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.TicketBooking;
import com.flightapp.repository.TicketBookingInfoRepo;
import com.flightapp.service.TiceketBookingService;
import com.flightapp.validation.EmailNotFound;
import com.flightapp.validation.PnrNumberNotFound;

@Service
public class TicketBookingServiceImpl implements TiceketBookingService {

	@Autowired
	private TicketBookingInfoRepo ticketBookingInfoRepo;

//	@Override
//	public Optional<TicketBooking> bookFlight(Integer flightNumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Integer bookFlight(TicketBooking ticket) {

		TicketBooking bookTicket = ticketBookingInfoRepo.save(ticket);

		return bookTicket.getId();
	}

	@Override
	public List<TicketBooking> getAllBookFlight() {

		return ticketBookingInfoRepo.findAll();
	}

	@Override
	public TicketBooking getFlightByPnr(Long pnrNumber) {

		try {
			return ticketBookingInfoRepo.findByPnrNumber(pnrNumber);
		} catch (Exception e) {
			// TODO: handle exception
			throw new PnrNumberNotFound("PNR Not Found ");
		}

	}

	@Override
	public List<TicketBooking> getByEmail(String email) {
		try {
			return ticketBookingInfoRepo.findByEmail(email);
		} catch (Exception e) {
			// TODO: handle exception
			throw new EmailNotFound("Email Not Found " + email);
		}

	}

	public void cancelBookFlight(Integer id) {
		// TODO Auto-generated method stub
		try {
			ticketBookingInfoRepo.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new PnrNumberNotFound("PNT Not Found "+id);
		}
		
	}

	

//	@Override
//	public TicketBooking bookFlight(TicketBooking bookFlight) {
//		// TODO Auto-generated method stub
//		return ticketBookingInfoRepo.save(bookFlight);
//	}

//	@Override
//	public Optional<TicketBooking> getBookingByPnrNo(Long pnrNumber) {
//		
//		return ticketBookingInfoRepo.findByPnrNumber(pnrNumber);
////		Optional<TicketBooking> booking_ticket=ticketBookingInfoRepo.findByPnrNumber(pnrNumber);
////		        return booking_ticket;   
//	}

}
