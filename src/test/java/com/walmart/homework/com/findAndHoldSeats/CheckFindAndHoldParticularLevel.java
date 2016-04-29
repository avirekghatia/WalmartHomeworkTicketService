package com.walmart.homework.com.findAndHoldSeats;

import com.walmart.homework.theatre.SeatHold;
import com.walmart.homework.theatre.SeatLevelWrapper;
import com.walmart.homework.theatre.TheatreTicketService;
import junit.framework.TestCase;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Krishna Ghatia on 4/29/2016.
 */
public class CheckFindAndHoldParticularLevel extends TestCase {

    public void testCheckHoldPartticularLevel(){
        TheatreTicketService theatreTicketService = new TheatreTicketService();
        Optional<Integer> minLevel = Optional.ofNullable(1);
        Optional<Integer> maxLevel = Optional.ofNullable(1);
        SeatHold seatHold = theatreTicketService.findAndHoldSeats(600, minLevel, maxLevel, "avirekghatia@nyu.edu");
        SeatHold seatHold1 = theatreTicketService.findAndHoldSeats(700, minLevel, maxLevel, "avirekghatia@nyu.edu");
        Set<SeatLevelWrapper> setHoldSet = seatHold.getHoldSet();
        int numberOfSeatsReserved = setHoldSet.size();
        assertTrue(numberOfSeatsReserved == 600);
        //No reservations made because greater than the capacity.
        assertTrue(seatHold1 == null);
    }

}
