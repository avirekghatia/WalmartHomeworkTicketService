package com.walmart.homework.com.findAndHoldSeats;

import com.walmart.homework.theatre.SeatHold;
import com.walmart.homework.theatre.SeatLevelWrapper;
import com.walmart.homework.theatre.TheatreTicketService;
import com.walmart.homework.theatre.VenueLevel;
import junit.framework.TestCase;

import java.util.Optional;
import java.util.Set;

/**
 * Junit test for testing how negative holds are handled.
 * Created by Avirek Ghatia on 4/29/2016.
 */

public class CheckFindAndHoldNegativeValues extends TestCase{

    /**
     * testing by passing negative number in the findAndHoldSeats method
     */
    public void testCheckFindAndHoldSeatsWithNegativeNumSeats(){

        TheatreTicketService theatreTicketService = new TheatreTicketService();
        int oldAvailableSeats = VenueLevel.ORCHESTRA.getAvailableSeats();
        Optional<Integer> minLevel = Optional.ofNullable(null);
        Optional<Integer> maxLevel = Optional.ofNullable(null);
        SeatHold seatHold = theatreTicketService.findAndHoldSeats(-10, minLevel, maxLevel, "avirekghatia@nyu.edu");
        SeatHold seatHold1 = theatreTicketService.findAndHoldSeats(0, minLevel, maxLevel, "avirekghatia@nyu.edu");
        assertTrue(seatHold == null);
        assertTrue(seatHold1 == null);
    }

}
