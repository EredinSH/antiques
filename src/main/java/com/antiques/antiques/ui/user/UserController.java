package com.antiques.antiques.ui.user;

import com.antiques.antiques.bean.UserBean;
import com.antiques.antiques.model.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@RequestScoped
@Named
public class UserController implements Serializable {

    @Inject
    UserBean userBean;

    @Inject
    UserForm userForm;


    @Inject
    UserDatabase userDatabase;

    public void remove(User user) {
        userBean.remove(user);
        userDatabase.refresh();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Usunięto użytkownika " + user.getId()));
    }

    public void saveUser() {
        if(userForm.getUserId() == null) {
            userForm.setUser(new User());
            return;
        }
        User user = userBean.find(userForm.getUserId());
        userForm.setUser(user);
    }

}
