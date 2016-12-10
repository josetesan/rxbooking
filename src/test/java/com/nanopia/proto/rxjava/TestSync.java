package com.nanopia.proto.rxjava;

import com.nanopia.proto.rxjava.entities.Flight;
import com.nanopia.proto.rxjava.entities.Passenger;
import com.nanopia.proto.rxjava.entities.Ticket;
import com.nanopia.proto.rxjava.dao.simple.FlightRepo;
import com.nanopia.proto.rxjava.dao.simple.PassengerRepo;
import com.nanopia.proto.rxjava.dao.simple.TicketBooking;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by josete on 10/12/16.
 */
public class TestSync {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestSync.class);

    private FlightRepo flightRepo;
    private PassengerRepo passengerRepo ;
    private TicketBooking ticketBooking;

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
