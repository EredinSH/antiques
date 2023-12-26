package com.antiques.antiques.bean;

import com.antiques.antiques.ui.item.ItemForm;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
@ApplicationScoped
public class CurrentPriceBean {

    @Inject
    ItemForm itemForm;

    private double currenPrice = itemForm.getItem().getPrice();

    public double getCurrenPrice() {
        return currenPrice;
    }

    public void setCurrenPrice(double currenPrice) {
        this.currenPrice = currenPrice;
    }
}
