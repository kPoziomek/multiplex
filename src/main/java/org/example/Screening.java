package org.example;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screening {
    private Movie movie;
    private Screen screen;
    private LocalDateTime dateTime;
    private Map<String, Reservation> reservations;
    private static  final int RESERVATIONS_PER_HOURS = 24;

    public Screening(Movie movie, Screen screen, LocalDateTime dateTime) {
        this.movie = movie;
        this.screen = screen;
        this.dateTime = dateTime;
        this.reservations = new HashMap<>();
    }

    public void reservePlaces(String... seatNumbers){
        reservePlaces(null, seatNumbers);
    }

    public void reservePlaces(Customer customer, String... seatNumbers){
        for(String seatNumber : seatNumbers){
            if(reservations.containsKey(seatNumber)){
                Reservation existingReservation = reservations.get(seatNumber);

                if(!existingReservation.isPaid() &&
                    existingReservation.getReservationDate().plusHours(RESERVATIONS_PER_HOURS).isBefore(LocalDateTime.now())) {
                    reservations.remove(seatNumber);
                }else {
                    throw new IllegalStateException("Seat" + seatNumber + " already reserved");
                }
            }
        }
        Reservation reservation = new Reservation(customer, Arrays.asList(seatNumbers),this);
        for(String seatNumber : seatNumbers){
            reservations.put(seatNumber, reservation);
        }
        if(customer != null){
            customer.addReservation(reservation);
        }
    }

    public void purchaseTickets(String... seatNumbers){
        purchaseTickets(null, seatNumbers);
    }

    public void purchaseTickets(Customer customer, String... seatNumbers){
        reservePlaces(customer, seatNumbers);
        Reservation reservation = reservations.get(seatNumbers[0]);
        reservation.markAsPaid();
    }

    public ReservationStatus getReservationStatus(){
        int totalSeats = screen.getTotalSeats();
        int reservedSeats = reservations.size();
        int paidSeats = (int) reservations.values().stream().distinct().filter(Reservation::isPaid).count();

        return new ReservationStatus(
                totalSeats,
                reservedSeats,
                paidSeats,
                totalSeats - reservedSeats
        );
    }

    public Movie getMovie() {
        return movie;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Screen getScreen() {
        return screen;
    }
}
