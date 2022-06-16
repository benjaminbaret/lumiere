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

    private String imageSource;

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

    public Movie() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRealisator(String realisator) {
        this.realisator = realisator;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setImage(FileInputStream image) {
        this.image = image;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getImageSource() {
        return imageSource;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return "Director : " + director;
    }

    public String getRealisator() {
        return "Realisator : " + realisator;
    }

    public String getGenre() {
        return "Genre : " + genre;
    }

    public String getActor() {
        return "Actor : " + actor;
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
        return "Description : \n" + description;
    }
}
