package com.antiques.antiques.bean;

import com.antiques.antiques.ui.item.ItemForm;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

@ManagedBean
public class ItemPriceBean {

    @ManagedProperty(value = "#{currentPriceBean}")
    CurrentPriceBean currentPriceBean;

    private Double newPrice;

    public CurrentPriceBean getCurrentPriceBean() {
        return currentPriceBean;
    }

    public void setCurrentPriceBean(CurrentPriceBean currentPriceBean) {
        this.currentPriceBean = currentPriceBean;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    public void validatePrice(Double value) throws ValidatorException {
        double previousPrice = currentPriceBean.getCurrenPrice();
        double newPrice = value;
        if(newPrice <= previousPrice) {
            FacesMessage message = new FacesMessage("Proponowana cena musi być wyższa od aktualnej!");
            throw new ValidatorException(message);
        }
        currentPriceBean.setCurrenPrice(value);
    }

    public String doValidate() {
        FacesContext context = FacesContext.getCurrentInstance();
        return "items";
    }
}
