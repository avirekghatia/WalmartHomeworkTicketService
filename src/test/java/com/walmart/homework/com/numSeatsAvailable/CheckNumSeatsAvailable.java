package com.walmart.homework.com.numSeatsAvailable;

import com.walmart.homework.theatre.TheatreTicketService;
import com.walmart.homework.theatre.VenueLevel;
import junit.framework.TestCase;

import java.util.Optional;

/**
 * Created by Krishna Ghatia on 4/29/2016.
 */
public class CheckNumSeatsAvailable extends TestCase {

    public void testNumSeatsAvailableWithNull(){

        TheatreTicketService theatreTicketService = new TheatreTicketService();
        int numSeatsAvailable = theatreTicketService.numSeatsAvailable(Optional.empty());
        int totalSeats = 0;
        for (VenueLevel v: VenueLevel.values()){
            totalSeats += v.getAvailableSeats();
        }
        assertTrue(numSeatsAvailable == totalSeats);

    }

    public void testNumSeatsAvailableWithLevel(){

        TheatreTicketService theatreTicketService = new TheatreTicketService();
        for (VenueLevel level : VenueLevel.values()){
            int levelNumber = level.getLevel();
            Optional<Integer> levelNumber1 = Optional.of(levelNumber);
            //int numSeats = theatreTicketService.numSeatsAvailable(levelNumber1);
            //assertTrue(numSeats == level.getAvailableSeats());
        }

    }


    public void testBogusIndexNumSeatsAvailableWithBogusValue() {
        TheatreTicketService theatreTicketService = new TheatreTicketService();
        int numSeatsAvailable = theatreTicketService.numSeatsAvailable(Optional.of(new Integer(0)));
        int totalSeats = 0;
        for (VenueLevel v : VenueLevel.values()) {
            totalSeats += v.getAvailableSeats();
        }
        assertTrue(numSeatsAvailable == -1);
    }


}
