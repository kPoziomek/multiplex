package org.example;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private int number;
    private final int ROWS = 10;
    private final int SEATS_PER_ROW = 12;



    private boolean has3DCapability;
    private boolean isVIP;
    private List<Seat> seats;

    public Screen(int number, boolean has3DCapability, boolean isVIP) {
        this.number = number;
        this.has3DCapability = has3DCapability;
        this.isVIP = isVIP;
        this.seats = new ArrayList<>();
        initializeSeats();
    }

    public int getNumber() {
        return number;
    }
    public int getTotalSeats() {
        return seats.size();
    }

    private void initializeSeats() {
        for (char row = ROWS; row <= SEATS_PER_ROW; row++) {
            for (int seatNum = 1; seatNum <= 15; seatNum++) {
                seats.add(new Seat(row + String.valueOf(seatNum)));
            }
        }
    }


}
