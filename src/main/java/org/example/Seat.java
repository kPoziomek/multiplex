package org.example;

public class Seat {
    private String seatNumber;
    private boolean isReserved;

    public Seat(String seatNumber){
        this.seatNumber = seatNumber;
        this.isReserved = false;
    }


    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }
}
