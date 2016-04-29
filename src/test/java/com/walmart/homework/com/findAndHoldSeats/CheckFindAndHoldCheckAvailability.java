package com.walmart.homework.com.findAndHoldSeats;

import com.walmart.homework.theatre.SeatHold;
import com.walmart.homework.theatre.SeatLevelWrapper;
import com.walmart.homework.theatre.TheatreTicketService;
import com.walmart.homework.theatre.VenueLevel;
import junit.framework.TestCase;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Avirek Ghatia on 4/29/2016.
 */
public class CheckFindAndHoldCheckAvailability extends TestCase {

    public void testCheckAvailableSeatsAfterHolding(){
        TheatreTicketService theatreTicketService = new TheatreTicketService();
        Optional<Integer> minLevel = Optional.ofNullable(null);
        Optional<Integer> maxLevel = Optional.ofNullable(null);
        SeatHold seatHold = theatreTicketService.findAndHoldSeats(600, minLevel, maxLevel, "avirekghatia@nyu.edu");
        SeatHold seatHold1 = theatreTicketService.findAndHoldSeats(1200, minLevel, maxLevel, "avirekghatia@nyu.edu");
        Set<SeatLevelWrapper> seatHoldSet = seatHold.getHoldSet();
        int numberOfSeatsReserved = seatHoldSet.size();
        Set<SeatLevelWrapper> seatHoldSet1 = seatHold1.getHoldSet();
        int numberOfSeatReserved1 = seatHoldSet1.size();
        int newAvailableSeats = VenueLevel.ORCHESTRA.getAvailableSeats();
        int newAvailableSeats1 = VenueLevel.MAIN.getAvailableSeats();
        assertTrue(newAvailableSeats == 0);
        assertTrue(numberOfSeatsReserved == 600);
        assertTrue(numberOfSeatReserved1 == 1200);
        assertTrue(newAvailableSeats1 == 1450);
    }

}
