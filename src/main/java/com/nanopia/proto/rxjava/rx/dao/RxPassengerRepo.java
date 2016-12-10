package com.nanopia.proto.rxjava.rx.dao;

import com.nanopia.proto.rxjava.entities.Passenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by josete on 10/12/16.
 */
public class RxPassengerRepo {

    private static final Logger LOGGER = LoggerFactory.getLogger(RxPassengerRepo.class);

    public Observable<Passenger> findPassenger(Long id)  {
        LOGGER.info("Searching passenger {}",id);
        return Observable.defer(() -> Observable.just(lookup(id)));
    }

    private Passenger lookup(Long id) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (final Exception ex) {

        }
        LOGGER.info("Found passenger {}",id);
        return new Passenger(id);
    }


}


