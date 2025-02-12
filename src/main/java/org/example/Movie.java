package org.example;

public class Movie {
    private String title;
    private int durationMinutes;
    private boolean  is3D;


    public Movie(String title, int durationMinutes, boolean is3D) {
        this.title = title;
        this.durationMinutes = durationMinutes;
        this.is3D = is3D;
    }

    public String getTitle() {
        return title;
    }

}
