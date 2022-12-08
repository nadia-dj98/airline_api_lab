package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Flights to Spain

        Flight flightToBilbao = new Flight("Bilbao", 150, "12/09/2023", "7pm");
        flightRepository.save(flightToBilbao);

        Flight flightToMalaga = new Flight("Malaga", 90, "28/12/2022", "8am");
        flightRepository.save(flightToMalaga);

        Flight flightToValencia = new Flight("Valencia", 140, "20/09/2023", "5:30am");
        flightRepository.save(flightToValencia);

        Passenger passenger1 = new Passenger("Nadia", "nadia_dj@hotmail.co.uk");
        passenger1.addPassengerToFlight(flightToBilbao);
        passenger1.addPassengerToFlight(flightToValencia);
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("Yasmine", "yasmine.dj@aol.com");
        passenger2.addPassengerToFlight(flightToMalaga);
        passenger2.addPassengerToFlight(flightToBilbao);
        passengerRepository.save(passenger2);

        //Flights to Algeria

        Flight flightToAlgiers = new Flight("Algiers", 95, "05/01/2023", "7pm");
        flightRepository.save(flightToAlgiers);
        passenger2.addPassengerToFlight(flightToAlgiers);
        passengerRepository.save(passenger2);

    }


}
