package com.invitation.entity;

import jakarta.persistence.*;

@Entity
public class WeddingCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String groomName;
    private String brideName;
    private String date;
    private String time;
    private String venue;
    private String message;


    public WeddingCard() {
    }

    public WeddingCard(String groomName, String brideName, String date, String time, String venue, String message) {
        this.groomName = groomName;
        this.brideName = brideName;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroomName() {
        return groomName;
    }

    public void setGroomName(String groomName) {
        this.groomName = groomName;
    }

    public String getBrideName() {
        return brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "WeddingCard{" +
                "id=" + id +
                ", groomName='" + groomName + '\'' +
                ", brideName='" + brideName + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", venue='" + venue + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
