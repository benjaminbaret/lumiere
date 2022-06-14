package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;

public class Movie {

    private String title;
    private String director;
    private String realisator;
    private String genre;
    private String actor;
    private Date releaseDate;
    private FileInputStream image;
    private Time duration;
    private String description;

    public Movie(String title, String director, String realisator, String genre, String actor, Date releaseDate, FileInputStream image, Time duration, String description) {
        this.title = title;
        this.director = director;
        this.realisator = realisator;
        this.genre = genre;
        this.actor = actor;
        this.releaseDate = releaseDate;
        this.image = image;
        this.duration = duration;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getRealisator() {
        return realisator;
    }

    public String getGenre() {
        return genre;
    }

    public String getActor() {
        return actor;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public FileInputStream getImage() {
        return image;
    }

    public Time getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
}
