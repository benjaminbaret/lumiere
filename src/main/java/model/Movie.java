package model;

public class Movie {
    private String title;
    private String description;
    private String director;
    private String genre;

    public Movie(String title, String description, String director, String genre) {
        this.title = title;
        this.description = description;
        this.director = director;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }
}
