package com.antiques.antiques.ui.item;

import com.antiques.antiques.bean.ItemBean;
import com.antiques.antiques.model.Item;
import org.omnifaces.cdi.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class ItemDatabase implements Serializable {
    @Inject
    ItemBean itemBean;

    @Inject
    ItemForm itemForm;

    @Inject
    ItemSearchForm itemSearchForm;

    private List<Item> values;

    public List<Item> getValues() {
        if (values == null) {
            refresh();
        }
        return values;
    }

    public void refresh() {
        if (itemSearchForm.getAuctionDateBefore() == null) {
            values = itemBean.getAllItems();
        } else {
            values = itemBean.getAuctionEndDateBefore(itemSearchForm.getAuctionDateBefore());
        }
    }

    public Item preRenderViewEvent() {
        return itemForm.getItem();
    }
}
