package com.antiques.antiques.ui.item;

import com.antiques.antiques.bean.ItemBean;
import com.antiques.antiques.model.Item;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@RequestScoped
@Named
public class ItemController implements Serializable {

    @Inject
    ItemBean itemBean;

    @Inject
    ItemDatabase itemDatabase;

    public void remove(Item item) {
        itemBean.remove(item);
        itemDatabase.refresh();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Usunięto przedmiot " + item.getId()));
    }
}
