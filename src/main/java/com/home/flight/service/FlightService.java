package com.home.flight.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.home.flight.beans.Flight;
import com.home.flight.data.FlightRepository;

/*
 * SERVICE CLASS - PERFORMS BUSINESS LOGIC
 * --------- ALL THE LOGIC IS HERE, INSTEAD OF CONTROLLER -------
 */

@Service
public class FlightService {

	@Autowired
	private FlightRepository repository;
	
	// ----- LOGIC ------ (for example if-else which doesn't belong in controller)

	
	
	// ------- ADD ----------
	public Flight save(Flight flight) {
		return repository.save(flight);
	}

	// -------- UPDATE BY ID --------
	public void updateById(Flight flight, Integer id) {
		if ((flight.getId() == id) && repository.findById(flight.getId()).isPresent()) {
			repository.save(flight);
		} else {
			throw new ValidationException(); // or can write custom validator
		}
	}

	// ------- FIND ALL -----
	public List<Flight> findAll() {
		return repository.findAll();
	}

	// ------- FIND BY ID ------
	public Flight findById(Integer id) {
		Optional<Flight> optional = repository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}
	
	


}

/*
 * 
 * 
 * 
 * 
 */
