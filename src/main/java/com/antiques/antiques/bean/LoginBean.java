package com.antiques.antiques.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class LoginBean {

    private String userLogin;
    private String userPassword;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        if(getUserLogin().trim().equals("admin") && getUserPassword().trim().equals("password123")) {
            return "adminWeb";
        }
        if(getUserLogin().trim().equals("user") && getUserPassword().trim().equals("password")) {
            return "mainPage";
        }
        else {
            context.addMessage(null, new FacesMessage( "Konto o podanych danych nie istnieje. Jesli zapomniales loginu lub hasla skontaktuj sie z administratorem strony!"));
        }
        return null;
    }
}
