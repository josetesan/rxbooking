package com.nanopia.proto.rxjava.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by josete on 10/12/16.
 */
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    Long id;
    Flight flight;
    Passenger passenger;


}
