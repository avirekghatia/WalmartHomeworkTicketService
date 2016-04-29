package com.walmart.homework.theatre;

/**
 * A state for the seat
 * Created by Avirek Ghatia on 4/24/2016.
 */
public class IsReserved extends SeatState {

    private Seat seat;

    /**
     * state constructor
     * @param seat the seat for which the state has to be set
     */
    public IsReserved(Seat seat) {
        this.seat = seat;
    }

    /**
     * reserve a seat which is in Reserved state
     */
    @Override
    public void reserve() {
        System.out.println("Seat is already reserved.");
    }

    /**
     * hold a seat which is reserved.
     */
    @Override
    public void hold() {
        System.out.println("Already reserved.");
    }

    /**
     * release the seat.
     */
    @Override
    public void releaseSeat() {
        System.out.println("Release seat");
    }
}
