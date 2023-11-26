package com.antiques.antiques.bean;

import com.antiques.antiques.database.ItemDatabaseOperation;
import com.antiques.antiques.model.Item;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@ManagedBean
@RequestScoped
public class ItemBean implements Serializable {

    public Long id;
    public String name;
    public String category;
    public int yearOfProduction;
    public Double price;
    public Date auctionEndDate;
    public String description;

    public List<Item> itemListFromDB;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setAuctionEndDate(Date auctionEndDate) {
        this.auctionEndDate = auctionEndDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItemListFromDB() {
        return itemListFromDB;
    }

    public void setItemListFromDB(List<Item> itemListFromDB) {
        this.itemListFromDB = itemListFromDB;
    }

    @PostConstruct
    public void init() {
        itemListFromDB = ItemDatabaseOperation.getAllItemsFromDatabase();
    }

    public List<Item> itemsList() {
        return itemListFromDB;
    }

    public String setItem() {
        return ItemDatabaseOperation.setItemInDatabase();
    }

    public String editItem(int itemId) {
        return ItemDatabaseOperation.editItemInDatabase(itemId);
    }

    public String updateItem(ItemBean item) {
        return ItemDatabaseOperation.updateItemInDatabase(item);
    }

    public String deleteItem(int itemId) {
        return ItemDatabaseOperation.deleteItemFromDatabase(itemId);
    }
}
