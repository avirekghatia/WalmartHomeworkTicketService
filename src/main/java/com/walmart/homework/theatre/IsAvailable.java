package com.walmart.homework.theatre;

/**
 * Represents the available state of a seat.
 *
 * @author Avirek Ghatia
 * Created by Avirek Ghatia on 4/24/2016.
 */
public class IsAvailable extends SeatState {

    private Seat seat;

    /**
     * constructor assigns the state for the seat.
     * @param seat seat which is to be set to available.
     */
    public IsAvailable(Seat seat) {
        this.seat = seat;
    }


    /**
     * reserve an available seat.
     */
    @Override
    public void reserve() {
        System.out.println("Seat should be held first.");
    }

    /**
     * hold a seat that is available.
     */
    @Override
    public void hold() {

    }

    /**
     * release the seat.
     */
    @Override
    public void releaseSeat() {

    }
}
