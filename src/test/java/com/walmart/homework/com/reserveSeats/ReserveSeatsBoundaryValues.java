package com.walmart.homework.com.reserveSeats;

import com.walmart.homework.theatre.SeatHold;
import com.walmart.homework.theatre.TheatreTicketService;
import com.walmart.homework.theatre.VenueLevel;
import junit.framework.TestCase;

import java.util.Optional;

/**
 * Created by @avirek on 4/29/2016.
 */
public class ReserveSeatsBoundaryValues extends TestCase {

    public void testReserveSeatsZeroHoldId(){

        TheatreTicketService theatreTicketService = new TheatreTicketService();

        String confirmationCode = theatreTicketService.reserveSeats(0, "avirekghatia@gmail.com");
        assertTrue(confirmationCode == null);

    }

    public void testReserveSeatsNullEmail(){

        TheatreTicketService theatreTicketService = new TheatreTicketService();
        String confirmationCode = theatreTicketService.reserveSeats(0, null);
        assertTrue(confirmationCode == null);

    }

}
