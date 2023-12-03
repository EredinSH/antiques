package com.antiques.antiques.ui.item;

import com.antiques.antiques.dao.ItemDao;
import com.antiques.antiques.model.Item;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class EditItemController {

    @Inject
    ItemForm itemForm;

    @Inject
    ItemDao itemDao;

    public void save() {
        itemDao.merge(itemForm.getItem());
    }

    public void preRenderViewEvent() {
        if(itemForm.getItem() == null) {
            initializeItems();
        }
    }

    public void initializeItems() {
        if(itemForm.getItemId() == null) {
            itemForm.setItem(new Item());
            return;
        }
        Item item = itemDao.find(itemForm.getItemId());
        itemForm.setItem(item);
    }
}

