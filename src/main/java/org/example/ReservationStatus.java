package org.example;

public class ReservationStatus {
    private final int totalSeats;
    private final int reservedSeats;
    private final int paidSeats;
    private final int availableSeats;

    public ReservationStatus(int totalSeats, int reservedSeats, int paidSeats, int availableSeats) {
        this.totalSeats = totalSeats;
        this.reservedSeats = reservedSeats;
        this.paidSeats = paidSeats;
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return String.format("""
            Status rezerwacji:
            - Całkowita liczba miejsc: %d
            - Miejsca zarezerwowane (niepotwierdzone): %d
            - Miejsca opłacone: %d
            - Miejsca dostępne: %d""",
                totalSeats,
                reservedSeats - paidSeats,
                paidSeats,
                availableSeats
        );
    }
}