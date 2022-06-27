package model;

import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;

/**
 * Movie class that represent a movie
 */
public class Movie {

    private String title;
    private String director;
    private String realisator;
    private String genre;
    private String actor;
    private Date releaseDate;
    private InputStream image;
    private Time duration;
    private String description;

    /**
     * @param title title of the movie
     * @param director director of the movie
     * @param realisator realisation of the movie
     * @param genre genre of the movie
     * @param actor actor of the movie
     * @param releaseDate releaseDate of the movie
     * @param image image of the movie
     * @param duration duration of the movie
     * @param description description of the movie
     */
    public Movie(String title, String director, String realisator, String genre, String actor, Date releaseDate, InputStream image, Time duration, String description) {
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

    /**
     * set the title of the movie
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * set the director of the movie
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * set the realisator of the movie
     * @param realisator
     */
    public void setRealisator(String realisator) {
        this.realisator = realisator;
    }

    /**
     * set the genre of the movie
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * set the actor of the movie
     * @param actor
     */
    public void setActor(String actor) {
        this.actor = actor;
    }

    /**
     * set the release date of the movie
     * @param releaseDate
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * set the image of the movie
     * @param image
     */
    public void setImage(InputStream image) {
        this.image = image;
    }

    /**
     * set the duration of the movie
     * @param duration
     */
    public void setDuration(Time duration) {
        this.duration = duration;
    }

    /**
     * set the description of the movie
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the title of the movie
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * get the director of the movie
     * @return String
     */
    public String getDirector() {
        return director;
    }

    /**
     * get the realisator of the movie
     * @return String
     */
    public String getRealisator() {
        return realisator;
    }

    /**
     * get the genre of the movie
     * @return String
     */
    public String getGenre() {
        return genre;
    }

    /**
     * get the actor of the movie
     * @return String
     */
    public String getActor() {
        return actor;
    }

    /**
     * get the release date of the movie
     * @return Date
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * return the image of the movie
     * @return InputStream
     */
    public InputStream getImage() {
        return image;
    }

    /**
     * return the duration of the movie
     * @return Time
     */
    public Time getDuration() {
        return duration;
    }

    /**
     * return the description of the movie
     * @return String
     */
    public String getDescription() {
        return description;
    }
}
