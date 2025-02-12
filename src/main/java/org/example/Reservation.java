package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private Customer customer;
    private List<String> seatNumbers;
    private Screening screening;
    private boolean isPaid;
    private LocalDateTime reservationDate;



    public Reservation(Customer customer, List<String> seatNumbers, Screening screening) {
        this.customer = customer;
        this.seatNumbers = seatNumbers;
        this.screening = screening;
        this.isPaid = false;
        this.reservationDate = LocalDateTime.now();
    }

    public void markAsPaid() {
        this.isPaid = true;
    }
    public boolean isPaid() {
        return this.isPaid;
    }

    public LocalDateTime getReservationDate() {
        return  reservationDate;
    }
    public Screening getScreening() {
        return screening;
    }
    public List<String> getSeatNumbers() {
        return new ArrayList<>(seatNumbers);
    }

    @Override
    public String toString() {
        return String.format("Film: %s, Data: %s, Miejsca: %s, Status: %s",
                screening.getMovie().getTitle(),
                screening.getDateTime(),
                String.join(", ",seatNumbers),
                isPaid ? "Opłacony":"Nieopłacony"
        );
    }
}
