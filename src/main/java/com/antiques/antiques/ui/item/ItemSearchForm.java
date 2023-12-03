package com.antiques.antiques.ui.item;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Date;

@SessionScoped
@Named
public class ItemSearchForm implements Serializable {
    private Date auctionEndDateExist;
    public Date getAuctionEndDateExist() {
        return auctionEndDateExist;
    }
    public void setAuctionEndDateExist(final Date auctionEndDateExist) {
        this.auctionEndDateExist = auctionEndDateExist;
    }
}
