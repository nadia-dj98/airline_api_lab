package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public FlightService(){}

    public List<Flight> displayAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> displaySpecificFlight(Long id){
        return flightRepository.findById(id);
    }
}
