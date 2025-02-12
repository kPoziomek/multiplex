package org.example;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Cinema cinema1 = new Cinema("Galeria Kazimierz", "ul. Rzeźnicza 1");
        Cinema cinema2 = new Cinema("Bonarka", "ul. Kamieńskiego 11");

        Screen screen1 = new Screen(1, true, false);
        Screen screen2 = new Screen(2, false, true);

        cinema1.addScreen(screen1);
        cinema1.addScreen(screen2);

        Movie movie1 = new Movie("James Bond", 120, false);
        Movie movie2 = new Movie("Avatar 2", 180, true);

        Screening screening1 = new Screening(movie1, screen1, LocalDateTime.now().plusDays(1));
        Screening screening2 = new Screening(movie2, screen1, LocalDateTime.now().plusDays(2));

        cinema1.addScreening(screening1);
        cinema1.addScreening(screening2);

        screening1.reservePlaces("H34", "H35", "H36");

        Customer customer = new Customer("jan@example.com");
        screening1.reservePlaces(customer, "A1", "A2");

        System.out.println("=== Program kina " + cinema1.getName() + " ===");
        cinema1.printProgramme();

        Movie foundMovie = cinema1.findMovie("James");

        System.out.println(screening1.getReservationStatus());

        screening1.purchaseTickets(customer, "B1", "B2");

        customer.printMyTickets();
    }
}