package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        List<Flight> flights;
        flights = flightService.displayAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity <Optional<Flight>> getFlightById(@PathVariable Long id){
        Optional<Flight> flights;
        flights = flightService.displaySpecificFlight(id);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        Flight savedFlight = flightService.addNewFlight(flight);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{flightId}/{passengerId}")
    public ResponseEntity<Flight> bookPassengerOnFlight(@PathVariable long flightId, @PathVariable long passengerId) {
        Flight flights;
        flights = flightService.bookPassengerOntoFlight(flightId, passengerId);
        return new ResponseEntity<>(flights, HttpStatus.CREATED);
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public  ResponseEntity cancelFlight(@PathVariable Long id){
        flightService.cancelFlight(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}
