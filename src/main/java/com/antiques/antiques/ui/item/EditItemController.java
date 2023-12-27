package com.antiques.antiques.ui.item;

import com.antiques.antiques.bean.ItemBean;
import com.antiques.antiques.model.Item;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class EditItemController {

    private Item item = new Item();

    @Inject
    ItemForm itemForm;

    @Inject
    ItemBean itemBean;

    public void save() {
        itemBean.merge(itemForm.getItem());
    }

    public void preRenderViewEvent() {
        if(itemForm.getItem() == null) {
            initializeItem();
        }
    }

    public void initializeItem() {
        if(itemForm.getItemId() == null) {
            itemForm.setItem(new Item());
            return;
        }
        Item item = itemBean.find(itemForm.getItemId());
        itemForm.setItem(item);
    }

    public void addNewItem() {
        itemBean.addNewItem(item);
        itemBean.getAllItems();
        this.item = new Item();
    }
}

