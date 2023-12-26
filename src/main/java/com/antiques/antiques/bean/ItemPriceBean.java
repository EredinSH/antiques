package com.antiques.antiques.bean;

import com.antiques.antiques.ui.item.ItemForm;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

@ManagedBean
public class ItemPriceBean {

    @Inject
    ItemForm itemForm;

    public void validatePrice(Object value) throws ValidatorException {
        double previousPrice = itemForm.getItem().getPrice();
        double newPrice = (Double) value;
        if(newPrice <= previousPrice) {
            FacesMessage message = new FacesMessage("Proponowana cena musi być wyższa od aktualnej!");
            throw new ValidatorException(message);
        }
        itemForm.getItem().setPrice(newPrice);
    }

    public String doValidate() {
        return "items";
    }
}
