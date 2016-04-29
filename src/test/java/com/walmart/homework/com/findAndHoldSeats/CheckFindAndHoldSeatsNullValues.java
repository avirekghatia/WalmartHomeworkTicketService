package com.walmart.homework.com.findAndHoldSeats;

import com.walmart.homework.theatre.SeatHold;
import com.walmart.homework.theatre.TheatreTicketService;
import junit.framework.TestCase;

import java.util.Optional;

/**
 * Created by @avirek on 4/29/2016.
 */
public class CheckFindAndHoldSeatsNullValues extends TestCase {

    public void testFindAndHoldZeroNumSeats(){

        TheatreTicketService theatreTicketService = new TheatreTicketService();
        int numSeats = 0;
        Optional<Integer> minLevel = Optional.of(1);
        Optional<Integer> maxLevel = Optional.of(2);
        String customerEmail = "avirekghatia@nyu.edu";
        SeatHold seatHold = theatreTicketService.findAndHoldSeats(numSeats, minLevel, maxLevel, customerEmail);
        assertTrue(seatHold == null);
    }

    public void testFindAndHoldNullLevels(){

        TheatreTicketService theatreTicketService = new TheatreTicketService();
        int numSeats = 12;
        String customerEmail = "avirekghatia@nyu.edu";
        SeatHold seatHold = theatreTicketService.findAndHoldSeats(numSeats, null, null, customerEmail);
        assertTrue(seatHold == null);
    }

    public void testFindAndHoldEmptyCustomerEmail(){

        TheatreTicketService theatreTicketService = new TheatreTicketService();
        Optional<Integer> minLevel = Optional.of(1);
        Optional<Integer> maxLevel = Optional.of(2);
        int numSeats = 12;
        String customerEmail = "";
        SeatHold seatHold = theatreTicketService.findAndHoldSeats(numSeats, minLevel, maxLevel, customerEmail);
        assertTrue(seatHold == null);
    }

}
