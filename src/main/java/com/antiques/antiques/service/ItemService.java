package com.antiques.antiques.service;

import com.antiques.antiques.model.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ItemService {

    @PersistenceContext
    private EntityManager entityManager;
    public List<Item> loadAllItems() {
        return this.entityManager.createQuery("SELECT i FROM item i", Item.class).getResultList();
    }

    public void addNewItem(Item item) {

        Item newItem = new Item();
        newItem.setId(item.getId());
        newItem.setName(item.getName());
        newItem.setCategory(item.getCategory());
        newItem.setYearOfProduction(item.getYearOfProduction());
        newItem.setPrice(item.getPrice());
        newItem.setAuctionEndDate(item.getAuctionEndDate());
        newItem.setDescription(item.getDescription());


        this.entityManager.persist(newItem);
    }

    public void updateItem(List<Item> item) {
        item.forEach(entityManager::merge);
    }

    public void deleteItem(Item item) {
        if (entityManager.contains(item)) {
            entityManager.remove(item);
        } else {
            Item managedItem = entityManager.find(Item.class, item.getId());
            if (managedItem != null) {
                entityManager.remove(managedItem);
            }
        }
    }
}
