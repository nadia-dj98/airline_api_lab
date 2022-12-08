package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public PassengerService() {

    }

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getOnePassenger(Long id){
        return passengerRepository.findById(id);
    }
}
