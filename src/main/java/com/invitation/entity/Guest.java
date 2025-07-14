package com.invitation.entity;

import jakarta.persistence.*;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String invitationSent;
    private String rsvpStatus;     

    public Guest() {
    }

    public Guest(String name, String email, String invitationSent, String rsvpStatus) {
        this.name = name;
        this.email = email;
        this.invitationSent = invitationSent;
        this.rsvpStatus = rsvpStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInvitationSent() {
        return invitationSent;
    }

    public void setInvitationSent(String invitationSent) {
        this.invitationSent = invitationSent;
    }

    public String getRsvpStatus() {
        return rsvpStatus;
    }

    public void setRsvpStatus(String rsvpStatus) {
        this.rsvpStatus = rsvpStatus;
    }


    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", invitationSent='" + invitationSent + '\'' +
                ", rsvpStatus='" + rsvpStatus + '\'' +
                '}';
    }
}
