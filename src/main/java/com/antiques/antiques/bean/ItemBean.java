package com.antiques.antiques.bean;


import com.antiques.antiques.model.Item;
import com.antiques.antiques.service.ItemService;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
public class ItemBean implements Serializable {

    private List<Item> itemList;

    private Item item = new Item();


    private ItemService itemService;


    public void init() {
        this.itemList = itemService.loadAllItems();
    }

    public void delete(Item item) {
        itemService.deleteItem(item);
        itemList.remove(item);
    }

    public void add() {
        itemService.addNewItem(item);
        this.itemList = itemService.loadAllItems();
        this.item = new Item();
    }

    public void update() {
        itemService.updateItem(itemList);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update item successful"));
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
}
