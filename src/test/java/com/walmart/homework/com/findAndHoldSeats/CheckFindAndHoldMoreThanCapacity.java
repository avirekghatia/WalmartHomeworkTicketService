package com.walmart.homework.com.findAndHoldSeats;

import com.walmart.homework.theatre.SeatHold;
import com.walmart.homework.theatre.TheatreTicketService;
import com.walmart.homework.theatre.VenueLevel;
import junit.framework.TestCase;

import java.util.Optional;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Krishna Ghatia on 4/29/2016.
 */
public class CheckFindAndHoldMoreThanCapacity extends TestCase {

    public void testCheckHoldMoreThanCapacity(){
        TheatreTicketService theatreTicketService = new TheatreTicketService();
        int oldAvailableSeats = VenueLevel.ORCHESTRA.getAvailableSeats();
        Optional<Integer> minLevel = Optional.ofNullable(null);
        Optional<Integer> maxLevel = Optional.ofNullable(null);
        SeatHold seatHold = theatreTicketService.findAndHoldSeats(7000, minLevel, maxLevel, "avirekghatia@nyu.edu");
        int newAvailableSeats = VenueLevel.ORCHESTRA.getAvailableSeats();

        assertTrue(oldAvailableSeats == newAvailableSeats);
        assertTrue(seatHold == null);
    }

}
