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
public class CheckFindAndHoldConsecutiveHold extends TestCase {

    public void testCheckAvailableSeatsAfterHoldingThread(){
        TheatreTicketService theatreTicketService = new TheatreTicketService();
        Optional<Integer> minLevel = Optional.ofNullable(null);
        Optional<Integer> maxLevel = Optional.ofNullable(null);
        SeatHold seatHold = theatreTicketService.findAndHoldSeats(600, minLevel, maxLevel, "avirekghatia@nyu.edu");
        try{
            Thread.sleep(30000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        SeatHold seatHold1 = theatreTicketService.findAndHoldSeats(1200, minLevel, maxLevel, "avirekghatia@nyu.edu");
        Set<SeatLevelWrapper> seatHoldSet = seatHold.getHoldSet();
        int numberOfSeatsReserved = seatHoldSet.size();
        Set<SeatLevelWrapper> seatHoldSet1 = seatHold1.getHoldSet();
        int numberOfSeatReserved1 = seatHoldSet1.size();
        int newAvailableSeats = VenueLevel.values()[0].getAvailableSeats();
        int newAvailableSeats1 = VenueLevel.values()[1].getAvailableSeats();
        assertTrue(newAvailableSeats == 50);
        assertTrue(numberOfSeatsReserved == 600);
        assertTrue(numberOfSeatReserved1 == 1200);
        assertTrue(newAvailableSeats1 == 2000);
    }

}
