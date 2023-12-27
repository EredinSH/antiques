package com.antiques.antiques.ui.user;

import com.antiques.antiques.model.User;
import org.omnifaces.cdi.ViewScoped;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class UserForm implements Serializable {

    private  Long userId;
    private User user;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
