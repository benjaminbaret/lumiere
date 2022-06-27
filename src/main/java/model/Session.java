package model;

import java.sql.Date;
import java.sql.Time;

/**
 * Session class which represent a session of a cinema
 */
public class Session {

    private String movieTitle;
    private String roomName;
    private Date sessionDate;
    private Time startTime;
    private Time endTime;

    /**
     * @param movieTitle title of the movie
     * @param roomName name of the room
     * @param sessionDate session date
     * @param startTime start time of the session
     * @param endTime end time of the session
     */
    public Session(String movieTitle, String roomName, Date sessionDate, Time startTime, Time endTime) {
        this.movieTitle = movieTitle;
        this.roomName = roomName;
        this.sessionDate = sessionDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * return the title of the movie
     * @return String
     */
    public String getMovieTitle() {
        return movieTitle;
    }


    /**
     * return the name of the room
     * @return String
     */
    public String getRoomName() {
        return roomName;
    }


    /**
     * return the date of the session
     * @return Date
     */
    public Date getSessionDate() {
        return sessionDate;
    }


    /**
     * return the start time of the session
     * @return Time
     */
    public Time getStartTime() {
        return startTime;
    }


    /**
     * return the end time of the session
     * @return Time
     */
    public Time getEndTime() {
        return endTime;
    }

}
