package com.antiques.antiques.ui.user;

import com.antiques.antiques.bean.UserBean;
import com.antiques.antiques.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class EditUserController {

    private User user = new User();

    @Inject
    UserForm userForm;

    @Inject
    UserBean userBean;

    public void save() {
        userBean.merge(userForm.getUser());
    }

    public void preRenderViewEvent() {
        if(userForm.getUser() == null) {
            initializeUser();
        }
    }

    public void initializeUser() {
        if(userForm.getUserId() == null) {
            userForm.setUser(new User());
            return;
        }
        User user = userBean.find(userForm.getUserId());
        userForm.setUser(user);
    }

    public void addUser() {
        userBean.addNewUser(user);
        userBean.getAllUsers();
        this.user = new User();
    }

}
