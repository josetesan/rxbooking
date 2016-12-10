package com.nanopia.proto.rxjava;

import com.nanopia.proto.rxjava.entities.Flight;
import com.nanopia.proto.rxjava.entities.Passenger;
import com.nanopia.proto.rxjava.entities.Ticket;
import com.nanopia.proto.rxjava.rx.dao.RxFlightRepo;
import com.nanopia.proto.rxjava.rx.dao.RxPassengerRepo;
import com.nanopia.proto.rxjava.rx.dao.RxTicketBooking;
import com.nanopia.proto.rxjava.simple.dao.FlightRepo;
import com.nanopia.proto.rxjava.simple.dao.PassengerRepo;
import com.nanopia.proto.rxjava.simple.dao.TicketBooking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rx.Observable;
import java.util.concurrent.TimeUnit;

/**
 * Created by josete on 10/12/16.
 */
public class Application {



    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) throws Exception{
        LOGGER.info("------ SYNC -----");
        syncBooking();
        LOGGER.info("------ RX -----");
        rxBooking();
        LOGGER.info("------ END -----");
    }

    private static void syncBooking() throws Exception {
        FlightRepo flightRepo = new FlightRepo();
        PassengerRepo passengerRepo = new PassengerRepo();
        TicketBooking ticketBooking = new TicketBooking();

        Flight flight =  flightRepo.findFlight("LAX-145");
        Passenger passenger = passengerRepo.findPassenger(4L);
        Ticket ticket = ticketBooking.bookTicket(flight, passenger);
        sendEmail(ticket);
    }

    private static void rxBooking() throws Exception {

        RxFlightRepo flightRepo = new RxFlightRepo();
        RxPassengerRepo passengerRepo = new RxPassengerRepo();
        RxTicketBooking ticketBooking = new RxTicketBooking();

        Observable<Flight> flight =  flightRepo.findFlight("LAX-145");
        Observable<Passenger> passenger = passengerRepo.findPassenger(4L);
        Observable<Ticket> ticket = flight
                .zipWith(passenger, (f,p) -> ticketBooking.bookTicket(f,p));
        ticket.subscribe(Application::sendEmail);



    }


    public static void sendEmail(Ticket ticket)  {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e ){}
        LOGGER.info("Sent email");
    }

}
