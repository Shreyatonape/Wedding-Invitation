package com.invitation.dao;

import com.invitation.entity.Guest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class GuestDAO {

    private EntityManager em;

    public GuestDAO(EntityManager em) {
        this.em = em;
    }

    public void addGuest(Guest guest) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(guest);
        tx.commit();
    }

    public void updateRSVP(int guestId, String status) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Guest guest = em.find(Guest.class, guestId);
        if (guest != null) {
            guest.setRsvpStatus(status);
        }
        tx.commit();
    }

    public List<Guest> getAllGuests() {
        return em.createQuery("from Guest", Guest.class).getResultList();
    }

    public List<Guest> getGuestsByRSVP(String status) {
        return em.createQuery("from Guest g where g.rsvpStatus = :status", Guest.class)
                .setParameter("status", status)
                .getResultList();
    }
}
