package com.antiques.antiques.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name= "id")
    private Long id;
    @Column(name = "name", length = 100, nullable=false)
    @NotNull
    private String name;
    @Column(name = "category", length = 30, nullable=false)
    @NotNull
    private String category;
    @Column(name = "yearOfProduction", length = 4, nullable=false)
    @NotNull
    private int yearOfProduction;
    @Column(name = "price", precision=8, scale=2, nullable=false)
    @NotNull
    private Double price;
    @Column(name = "auctionEndDate", nullable=false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date auctionEndDate;
    @Column(name = "description", length = 3000, nullable=false)
    @NotNull
    private String description;

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
}
