package com.nanopia.proto.rxjava.dao.simple;

import com.nanopia.proto.rxjava.entities.Passenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by josete on 10/12/16.
 */
public class PassengerRepo {

    private static final Logger LOGGER = LoggerFactory.getLogger(PassengerRepo.class);

    public Passenger findPassenger(Long id) throws Exception {
        LOGGER.info("Searching passenger {}",id);
        TimeUnit.SECONDS.sleep(1);
        LOGGER.info("Found passenger {}",id);
        return new Passenger(id)  ;
    }
}
