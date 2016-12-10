package com.nanopia.proto.rxjava.rx.dao;

import com.nanopia.proto.rxjava.entities.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by josete on 10/12/16.
 */
public class RxFlightRepo {


    private static final Logger LOGGER = LoggerFactory.getLogger(RxFlightRepo.class);

    public Observable<Flight> findFlight(String name)  {
        LOGGER.info("Searching flight {}",name);
        return Observable.defer(() -> Observable.just(lookup(name)));
    }

    private Flight lookup(String name) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (final Exception ex) {

        }
        LOGGER.info("Found flight {}",name);
        return new Flight(name)  ;
    }
}
