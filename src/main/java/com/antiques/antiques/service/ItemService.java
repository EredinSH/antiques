package com.antiques.antiques.service;

import com.antiques.antiques.model.Item;
import com.github.adminfaces.template.exception.BusinessException;
import jakarta.ejb.Stateless;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.github.adminfaces.template.util.Assert.has;

@Stateless
public class ItemService implements Serializable {

    List<Item> itemsList;

    public List<Item> getItemsList() {
        return itemsList;
    }

    public List<Item> listByCategory(String category) {
        return itemsList.stream()
                .filter(i -> i.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public void insert(Item item) {
        validate(item);
        item.setId(itemsList.stream()
                .mapToInt(Item::getId)
                .max()
                .getAsInt()+1);
        itemsList.add(item);
    }

    public void validate(Item item) {
        BusinessException be = new BusinessException();
        if(!item.hasName()) {
            be.addException(new BusinessException("Item name cannot be empty!"));
        }
        if(!item.hasCategory()) {
            be.addException(new BusinessException("Item category cannot be empty!"));
        }
        if(!item.hasPrice()) {
            be.addException(new BusinessException("Item price cannot be empty!"));
        }
        if(!item.hasAuctionEndDate()) {
            be.addException(new BusinessException("Item auction end date cannot be empty!"));
        }
        if(has(be.getExceptionList())) {
            throw be;
        }
    }

    public void remove(Item item) {
        itemsList.remove(item);
    }

    public Item findById(int id) {
        return itemsList.stream()
                .filter(i -> Objects.equals(i.getId(), id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("Item with id: " + id + " doesn't exist"));
    }

    public void update(Item item) {
        validate(item);
        itemsList.remove(item);
        itemsList.add(item);
    }

}
