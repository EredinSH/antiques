package com.antiques.antiques.ui.item;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Date;

@SessionScoped
@Named
public class ItemSearchForm implements Serializable {
    private Date auctionDateBefore;

    public Date getAuctionDateBefore() {
        return auctionDateBefore;
    }

    public void setAuctionDateBefore(Date auctionDateBefore) {
        this.auctionDateBefore = auctionDateBefore;
    }
}
