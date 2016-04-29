package com.walmart.homework.com.findAndHoldSeats;

import com.walmart.homework.theatre.SeatHold;
import com.walmart.homework.theatre.SeatLevelWrapper;
import com.walmart.homework.theatre.TheatreTicketService;
import com.walmart.homework.theatre.VenueLevel;
import junit.framework.TestCase;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Krishna Ghatia on 4/29/2016.
 */
public class CheckFindAndHoldSeatsAsNullable extends TestCase {


    public void testMinMaxValuesAsNullable(){

        TheatreTicketService theatreTicketService = new TheatreTicketService();
        int oldAvailableSeats = VenueLevel.ORCHESTRA.getAvailableSeats();
        Optional<Integer> minLevel = Optional.ofNullable(null);
        Optional<Integer> maxLevel = Optional.ofNullable(null);
        SeatHold seatHold = theatreTicketService.findAndHoldSeats(100, minLevel, maxLevel, "avirekghatia@nyu.edu");
        Set<SeatLevelWrapper> seatHoldSet = seatHold.getHoldSet();
        int numberOfSeatsReserved = seatHoldSet.size();
        int newAvailableSeats = VenueLevel.ORCHESTRA.getAvailableSeats();

        System.out.println("oldAvailableSeats: "+oldAvailableSeats);
        assertTrue(oldAvailableSeats == newAvailableSeats+100);
        System.out.println("numberOfSeatsReserved: "+numberOfSeatsReserved);
        assertTrue(numberOfSeatsReserved == 100);

    }

}
