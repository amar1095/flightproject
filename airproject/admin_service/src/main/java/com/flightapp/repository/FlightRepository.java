package com.flightapp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.FlightDetails;


public interface FlightRepository extends JpaRepository<FlightDetails, Integer> {
	Optional<FlightDetails> findByOperatingAirlines(String flightName);
//
	Optional<FlightDetails> findByFlightNumber(Integer flightNumber);
//
	List<Object> findByFromPlaceAndToPlace(String fromPlace, String toPlace);
//
//	// @Query("select
//	// flightNumber,operatingAirlines,fromPlace,toPlace,startDate,endDate,cost,dateOfDeparture
//	// from AddFlightDetails where fromPlace=:fromPlace and toPlace=:toPlace")
//	List<Object> findByFromAndTo(String fromPlace, String toPlace);
//
//	// @Query("FROM AddFlightDetails WHERE fromPlace =:fromPlace and toPlace
//	// =:toPlace and cast(startDate as date) =:startDate")
//	List<FlightDetails> searchFlight(String fromPlace, String toPlace, Date startDate);

}
