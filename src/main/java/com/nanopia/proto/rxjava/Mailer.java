package com.nanopia.proto.rxjava;

import com.nanopia.proto.rxjava.entities.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by josete on 10/12/16.
 */
public class Mailer {

    private static Logger LOGGER = LoggerFactory.getLogger(Mailer.class);

    public static void sendEmail(Ticket ticket)  {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e ){}
        LOGGER.info("Sent email for ticket {}", ticket);
    }
}
