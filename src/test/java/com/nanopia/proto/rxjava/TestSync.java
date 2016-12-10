package com.nanopia.proto.rxjava;

import com.nanopia.proto.rxjava.entities.Flight;
import com.nanopia.proto.rxjava.entities.Passenger;
import com.nanopia.proto.rxjava.entities.Ticket;
import com.nanopia.proto.rxjava.simple.dao.FlightRepo;
import com.nanopia.proto.rxjava.simple.dao.PassengerRepo;
import com.nanopia.proto.rxjava.simple.dao.TicketBooking;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by josete on 10/12/16.
 */
public class TestSync {

    FlightRepo flightRepo;
    PassengerRepo passengerRepo ;
    TicketBooking ticketBooking;

    @Before
    public void setup() {
         flightRepo = new FlightRepo();
         passengerRepo = new PassengerRepo();
         ticketBooking = new TicketBooking();
    }


    @Test
    public void testSync() throws Exception {

        Flight flight =  flightRepo.findFlight("LAX-145");
        Passenger passenger = passengerRepo.findPassenger(4L);
        Ticket ticket = ticketBooking.bookTicket(flight, passenger);
        Mailer.sendEmail(ticket);
    }
}
