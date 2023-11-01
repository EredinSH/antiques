package com.antiques.antiques.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="ITEMS")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "yearOfProduction")
    private int yearOfProduction;
    @Column(name = "price")
    private Double price;
    @Column(name = "auctionEndDate")
    private Date auctionEndDate;
    @Column(name = "description")
    private String description;

    public Item() {
    }

    public Item(int id, String name, String category, int yearOfProduction, Double price, Date auctionEndDate, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.yearOfProduction = yearOfProduction;
        this.price = price;
        this.auctionEndDate = auctionEndDate;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && yearOfProduction == item.yearOfProduction && Objects.equals(name, item.name) && Objects.equals(category, item.category) && Objects.equals(price, item.price) && Objects.equals(auctionEndDate, item.auctionEndDate) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, yearOfProduction, price, auctionEndDate, description);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", price=" + price +
                ", auctionEndDate=" + auctionEndDate +
                ", description='" + description + '\'' +
                '}';
    }

    public boolean hasName() {
        return name != null && !"".equals(name.trim());
    }

    public boolean hasCategory() {
        return category != null && !"".equals(category.trim());
    }

    public boolean hasPrice() {
        return price != null;
    }

    public boolean hasAuctionEndDate() {
        return auctionEndDate != null;
    }

}
