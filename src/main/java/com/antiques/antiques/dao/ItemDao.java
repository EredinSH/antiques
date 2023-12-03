package com.antiques.antiques.dao;

import com.antiques.antiques.model.Item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

/**
 {@link Item} entity.
 */

@Stateless
public class ItemDao {

    @PersistenceContext
    private EntityManager em;

    public List<Item> getAllItems() {
        TypedQuery<Item> query = em.createQuery("SELECT i FROM Item i", Item.class);
        return query.getResultList();
    }

    public List<Item> getAuctionEndDateExist(Date auctionEndDateExist) {
        TypedQuery<Item> query = em.createQuery("SELECT i FROM Item i WHERE i.auctionEndDate >= :auctionEndDateExist", Item.class);
        query.setParameter("auctionEndDateExist", auctionEndDateExist);
        return query.getResultList();
    }

    public Item find(Long id) {
        return em.find(Item.class, id);
    }

    public Item merge(Item item) {
        return em.merge(item);
    }

    public void persist(Item item) {
        em.persist(item);
    }

    public void remove(Item item) {
        Item attached = find(item.getId());
        em.remove(attached);
    }
}
