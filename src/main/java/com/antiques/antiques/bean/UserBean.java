package com.antiques.antiques.bean;

import com.antiques.antiques.model.User;
import javax.faces.application.FacesMessage;
import com.antiques.antiques.service.UserService;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
public class UserBean implements Serializable {

    private List<User> customersList;

    private User user = new User();


    private UserService userService;


    public void init() {
        this.customersList = userService.loadAllUsers();
    }

    public void delete(User user) {
        userService.deleteUser(user);
        customersList.remove(user);
    }

    public void add() {
        userService.addNewUser(user);
        this.customersList = userService.loadAllUsers();
        this.user = new User();
    }

    public void update() {
        userService.updateUser(customersList);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update item successful"));
    }

    public List<User> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<User> customersList) {
        this.customersList = customersList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
