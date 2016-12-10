package com.nanopia.proto.rxjava.dao.simple;

import com.nanopia.proto.rxjava.entities.Flight;
import com.nanopia.proto.rxjava.entities.Passenger;
import com.nanopia.proto.rxjava.entities.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by josete on 10/12/16.
 */
public class TicketBooking {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketBooking.class);

    public static Ticket bookTicket(Flight flight, Passenger passenger) throws Exception {
        LOGGER.info("Booking flight {} for passenger {}",flight ,passenger);
        TimeUnit.SECONDS.sleep(1);
        Ticket ticket =  new Ticket(1L,flight,passenger);
        LOGGER.info("Booked ticket {}",ticket)  ;
        return ticket;
    }
}
