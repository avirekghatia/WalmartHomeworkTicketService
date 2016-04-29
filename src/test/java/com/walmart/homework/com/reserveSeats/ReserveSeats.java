package com.walmart.homework.com.reserveSeats;

import com.walmart.homework.theatre.SeatHold;
import com.walmart.homework.theatre.TheatreTicketService;
import com.walmart.homework.theatre.VenueLevel;
import junit.framework.TestCase;

import java.util.Optional;

/**
 * Created by Krishna Ghatia on 4/29/2016.
 */
public class ReserveSeats extends TestCase {

    public void testReserveSeatsWithTimeStamp(){

        TheatreTicketService theatreTicketService = new TheatreTicketService();
        Optional<Integer> minLevel = Optional.ofNullable(null);
        Optional<Integer> maxLevel = Optional.ofNullable(null);
        SeatHold seatHold = theatreTicketService.findAndHoldSeats(600, minLevel, maxLevel, "avirekghatia@nyu.edu");
        try{
            Thread.sleep(30000);
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        SeatHold seatHold1 = theatreTicketService.findAndHoldSeats(1200, minLevel, maxLevel, "avirekghatia@nyu.edu");
        if(seatHold1 != null){
            int seatHoldId = seatHold1.getHoldId();
            String confirmationCode = theatreTicketService.reserveSeats(seatHoldId, "avirekghatia@gmail.com");
        }

        int newAvailableSeats = VenueLevel.ORCHESTRA.getAvailableSeats();
        int newAvailableSeats1 = VenueLevel.MAIN.getAvailableSeats();
        int newAvailableSeats2 = VenueLevel.BALCONY1.getAvailableSeats();
        int newAvailableSeats3 = VenueLevel.BALCONY2.getAvailableSeats();
        assertTrue(newAvailableSeats == 50);
        assertTrue(newAvailableSeats1 == 2000);
        assertTrue(newAvailableSeats2 == 1500);
        assertTrue(newAvailableSeats3 == 1500);


    }

}
