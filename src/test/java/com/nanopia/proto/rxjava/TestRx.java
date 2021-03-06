package com.nanopia.proto.rxjava;

import com.nanopia.proto.rxjava.dao.rx.RxFlightRepo;
import com.nanopia.proto.rxjava.dao.rx.RxPassengerRepo;
import com.nanopia.proto.rxjava.dao.simple.TicketBooking;
import com.nanopia.proto.rxjava.entities.Flight;
import com.nanopia.proto.rxjava.entities.Passenger;
import com.nanopia.proto.rxjava.entities.Ticket;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

/**
 * Created by josete on 10/12/16.
 */
public class TestRx {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestRx.class);

    private RxFlightRepo flightRepo;
    private RxPassengerRepo passengerRepo;
    private TicketBooking ticketBooking;

    @Before
    public void setup() {
         flightRepo = new RxFlightRepo();
         passengerRepo = new RxPassengerRepo();
         ticketBooking = new TicketBooking();
    }

    @Test
    public void testRx() throws Exception {
        LOGGER.info("Starting")  ;
        Observable<Flight> flight =  flightRepo.findFlight("LAX-145");
        Observable<Passenger> passenger = passengerRepo.findPassenger(4L);
        Observable<Ticket> ticket = flight
                .zipWith(passenger, (f,p) -> ticketBooking.bookTicket(f,p));
        LOGGER.info("Subscribing")  ;
        ticket.subscribe(Mailer::sendEmail);
    }
}
