package com.invitation.dao;

import com.invitation.entity.WeddingCard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class WeddingCardDAO {

    private EntityManager em;

    public WeddingCardDAO(EntityManager em) {
        this.em = em;
    }

    public void createWeddingCard(WeddingCard card) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(card);
        tx.commit();
    }

    public List<WeddingCard> getAllWeddingCards() {
        return em.createQuery("from WeddingCard", WeddingCard.class).getResultList();
    }
    
    public WeddingCard getWeddingCardById(int id) {
        return em.find(WeddingCard.class, id);
    }
}
