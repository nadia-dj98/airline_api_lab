package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public Flight addNewFlight(Flight flight) {

        flightRepository.save(flight);
        return flight;
    }

    //book passenger onto flight method -> struggling

//    public List<Flight> bookPassengerOntoFlight(Long id){
//
//    }


    //book passenger onto flight

    public Flight bookPassengerOntoFlight(long flightId, long passengerId ){
        Flight flight = flightRepository.findById(flightId).get();
        Passenger passenger = passengerRepository.findById(passengerId).get();
        List <Passenger> passengers = flight.getPassengers();
        passengers.add(passenger);
        flight.setPassengers(passengers);
        flightRepository.save(flight);
        return flight;
    }




    //cancel a flight

    public void cancelFlight(Long id) {
        flightRepository.deleteById(id);
    }
}

