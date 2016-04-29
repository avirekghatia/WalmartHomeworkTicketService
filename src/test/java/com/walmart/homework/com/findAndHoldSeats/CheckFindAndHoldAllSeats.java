package com.walmart.homework.com.findAndHoldSeats;

import com.walmart.homework.theatre.SeatHold;
import com.walmart.homework.theatre.SeatLevelWrapper;
import com.walmart.homework.theatre.TheatreTicketService;
import com.walmart.homework.theatre.VenueLevel;
import junit.framework.TestCase;

import java.util.Optional;
import java.util.Set;

/**
 * Junit tests for checking if application fails if all seats are reserved.
 * Created by Avirek Ghatia on 4/29/2016.
 */
public class CheckFindAndHoldAllSeats extends TestCase {

    /**
     * Test if holding all seats creates any error.
     */

    public void testCheckHoldAllSeats(){
        TheatreTicketService theatreTicketService = new TheatreTicketService();
        Optional<Integer> minLevel = Optional.ofNullable(null);
        Optional<Integer> maxLevel = Optional.ofNullable(null);
        SeatHold seatHold = theatreTicketService.findAndHoldSeats(6000, minLevel, maxLevel, "avirekghatia@nyu.edu");
        SeatHold seatHold1 = theatreTicketService.findAndHoldSeats(250, minLevel, maxLevel, "avirekghatia@nyu.edu");
        Set<SeatLevelWrapper> seatHoldSet = seatHold.getHoldSet();
        int numberOfSeatsReserved = seatHoldSet.size();
        Set<SeatLevelWrapper> seatHoldSet1 = seatHold1.getHoldSet();
        int numberOfSeatReserved1 = seatHoldSet1.size();
        assertTrue(numberOfSeatReserved1 == 250);
        assertTrue(numberOfSeatsReserved == 6000);
        for (VenueLevel venueLevel : VenueLevel.values()){
            assertTrue(venueLevel.getAvailableSeats() == 0);
        }
        assertTrue(numberOfSeatReserved1 == 250);
        assertTrue(numberOfSeatsReserved == 6000);
    }

}
