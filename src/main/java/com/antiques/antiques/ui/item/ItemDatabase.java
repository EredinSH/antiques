package com.antiques.antiques.ui.item;

import com.antiques.antiques.dao.ItemDao;
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
    ItemDao itemDao;

    @Inject
    ItemSearchForm itemSearchForm;

    private List<Item> values;

    public List<Item> getValues() {
        if(values==null) {
            refresh();
        }
        return values;
    }

    public void refresh() {
        if(itemSearchForm.getAuctionEndDateExist() == null) {
            values = itemDao.getAllItems();
        } else {
            values = itemDao.getAuctionEndDateExist(itemSearchForm.getAuctionEndDateExist());
        }
    }
}
