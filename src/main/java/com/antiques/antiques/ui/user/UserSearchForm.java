package com.antiques.antiques.ui.user;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class UserSearchForm implements Serializable {

    private Double userAccount;
    public Double getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(final Double userAccount) {
        this.userAccount = userAccount;
    }

}
