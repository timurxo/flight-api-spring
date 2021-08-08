package com.home.flight.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.home.flight.beans.Flight;
import com.home.flight.data.FlightRepository;
import com.home.flight.service.FlightService;

// ---------------------- DISPATCHER SERVLET ------------------------

/*
 * 
 * @ResponseBody // whatever is returned is written directly to the HTTP response body
 * 
 *  DispatcherServlet - front controller of spring
 *	 	FORWARD REQUESTS to other controllers
 * 
 * 
 */

@RestController // @Controller + makes us avoid using @ResponseBody in every single method
@RequestMapping("/flights")
public class FlightController {


	@Autowired
	private FlightService service;

	// ------- ADD -----
	// method is invoked when post request is sent to /flight
	@PostMapping(value = "/flight") // @Valid means it will validate object before executing the body
	public ResponseEntity<Flight> save(@RequestBody @Valid Flight flight) { // gets Flight JSON from HTTP request body
		Flight body = service.save(flight);
		return new ResponseEntity<>(body, HttpStatus.CREATED); 
	}
	
	

	// ------- FIND ALL -----
	@GetMapping(value = "/flight") // ******* if value is deleted then request will be send to localhost.../flights
	public ResponseEntity<List<Flight>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	

	// ------ FIND BY FLIGHT ID -----
	@GetMapping("/flight/{id}")
	public ResponseEntity<Flight> findById(@PathVariable Integer id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	
	
	
	// ------- UPDATE BY ID ------
	// localhost:9001/flights/flight?id=1
	@PutMapping(value = "/flight/{id}")
	public ResponseEntity<Void> updateById(@RequestBody Flight flight, @PathVariable("id") Integer id) { // @PathVariable
																										// takes id from
																										// value={../{id}}
		service.updateById(flight, id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		return new ResponseEntity<>(service.updateById(flight, id), HttpStatus.CREATED);
	}

}

/*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*/