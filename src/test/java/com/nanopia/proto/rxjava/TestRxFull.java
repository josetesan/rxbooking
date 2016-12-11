package com.nanopia.proto.rxjava;

import com.nanopia.proto.rxjava.dao.rx.RxFlightRepo;
import com.nanopia.proto.rxjava.dao.rx.RxPassengerRepo;
import com.nanopia.proto.rxjava.dao.rx.RxTicketBooking;
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
public class TestRxFull {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestRxFull.class);

    private RxFlightRepo flightRepo;
    private RxPassengerRepo passengerRepo;
    private RxTicketBooking ticketBooking;

    @Before
    public void setup() {
         flightRepo = new RxFlightRepo();
         passengerRepo = new RxPassengerRepo();
         ticketBooking = new RxTicketBooking();
    }

    @Test
    public void testRxFull() throws Exception {
        LOGGER.info("Starting")  ;
        Observable<Flight> flight =  flightRepo.findFlight("LAX-145");
        Observable<Passenger> passenger = passengerRepo.findPassenger(4L);
        Observable<Ticket> ticket = flight
                .zipWith(passenger, (Flight f,Passenger p) -> ticketBooking.bookTicket(f,p))
                .flatMap(obs -> obs);
        LOGGER.info("Subscribing")  ;
        ticket.subscribe(Mailer::sendEmail);
    }
}
