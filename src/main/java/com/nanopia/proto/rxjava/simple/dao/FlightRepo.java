package com.nanopia.proto.rxjava.simple.dao;

import com.nanopia.proto.rxjava.entities.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by josete on 10/12/16.
 */
public class FlightRepo {


    private static final Logger LOGGER = LoggerFactory.getLogger(FlightRepo.class);

    public Flight findFlight(String name) throws Exception {
        LOGGER.info("Searching flight {}",name);
        TimeUnit.SECONDS.sleep(1);
        LOGGER.info("Found flight {}",name);
        return new Flight(name);
    }
}
