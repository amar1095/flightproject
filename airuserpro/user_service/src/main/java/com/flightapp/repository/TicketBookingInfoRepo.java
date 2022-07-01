package com.flightapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.TicketBooking;

@Repository
public interface TicketBookingInfoRepo extends JpaRepository<TicketBooking, Integer> {

	TicketBooking findByPnrNumber(Long pnrNumber);

//	Optional<TicketBooking> findById(Integer flightNumber);
//
//	Optional<TicketBooking> findByPnrNumber(Long pnrNumber);
//	
	List<TicketBooking> findByEmail(String email);

	void deleteByPnrNumber(Long pnrNumber);


}
