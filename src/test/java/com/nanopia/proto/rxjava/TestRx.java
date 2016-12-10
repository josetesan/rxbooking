package com.nanopia.proto.rxjava;

import com.nanopia.proto.rxjava.entities.Flight;
import com.nanopia.proto.rxjava.entities.Passenger;
import com.nanopia.proto.rxjava.entities.Ticket;
import com.nanopia.proto.rxjava.dao.rx.RxFlightRepo;
import com.nanopia.proto.rxjava.dao.rx.RxPassengerRepo;
import com.nanopia.proto.rxjava.dao.rx.RxTicketBooking;
import org.junit.Before;
import org.junit.Test;
import rx.Observable;

/**
 * Created by josete on 10/12/16.
 */
public class TestRx {


    RxFlightRepo flightRepo;
    RxPassengerRepo passengerRepo;
    RxTicketBooking ticketBooking;

    @Before
    public void setup() {
         flightRepo = new RxFlightRepo();
         passengerRepo = new RxPassengerRepo();
         ticketBooking = new RxTicketBooking();
    }

    @Test
    public void testRx() throws Exception {
        Observable<Flight> flight =  flightRepo.findFlight("LAX-145");
        Observable<Passenger> passenger = passengerRepo.findPassenger(4L);
        Observable<Ticket> ticket = flight
                .zipWith(passenger, (f,p) -> ticketBooking.bookTicket(f,p));
        ticket.subscribe(Mailer::sendEmail);
    }
}
