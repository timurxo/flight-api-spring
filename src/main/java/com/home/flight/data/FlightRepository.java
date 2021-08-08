package com.home.flight.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.flight.beans.Flight;

// Repository always centered around 1 object (its a CRUD only for 1 object)
// 		here Integer is a type of our id
@Repository // manages transaction processing
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	
	// CRUD methods
	
	public List<Flight> findByFlightNumber(String flightNumber); 

}
