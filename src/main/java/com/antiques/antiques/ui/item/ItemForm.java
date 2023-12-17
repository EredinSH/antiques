package com.antiques.antiques.ui.item;

import com.antiques.antiques.model.Item;
import org.omnifaces.cdi.ViewScoped;

import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class ItemForm implements Serializable {

    private Long itemId;
    private Item item;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(final Long itemId) {
        this.itemId = itemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(final Item item) {
        this.item = item;
    }

}
