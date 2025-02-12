package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cinema {
    private String name;
    private String address;
    private List<Screen> screens;
    private List<Screening> screenings;

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.screens = new ArrayList<>();
        this.screenings = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }

    public void addScreening(Screening screening) {
        this.screenings.add(screening);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void printProgramme() {
        LocalDate today = LocalDate.now();
        screenings.stream()
                .filter(s -> !s.getDateTime().toLocalDate().isAfter(today.plusDays(7)))
                .sorted(Comparator.comparing(Screening::getDateTime))
                .forEach(screening -> System.out.printf("%s - %s, Sala %d%n",
                        screening.getDateTime(),
                        screening.getMovie().getTitle(),
                        screening.getScreen().getNumber()));
    }

    public Movie findMovie(String title) {
        return screenings.stream()
                .map(Screening::getMovie)
                .filter(m -> m.getTitle().contains(title))
                .findFirst()
                .orElse(null);
    }

    public List<Screening> getScreenings() {
        return new ArrayList<>(screenings);
    }
}
