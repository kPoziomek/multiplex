package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private String email;
    private List<Reservation> reservations;


    public Customer(String email) {
        this.email = email;
        this.reservations = new ArrayList<>();
    }
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
    public List<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    public List<Reservation> getActiveReservations() {
        LocalDateTime now = LocalDateTime.now();
        return reservations.stream()
                .filter(r -> r.getScreening().getDateTime().isAfter(now))
                .sorted(Comparator.comparing(r-> r.getScreening().getDateTime()))
                .collect(Collectors.toList());
    }

    public void printMyTickets(){
        System.out.println("=== Twoje Bilety ===");
        getReservations().forEach(System.out::println);
    }

}
