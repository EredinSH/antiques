package com.antiques.antiques.bean;

import com.antiques.antiques.database.UserDatabaseOperation;
import com.antiques.antiques.model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class UserBean implements Serializable {

    public int id;

    public String name;
    public String surname;
    public int age;
    public String nick;
    public String mail;
    public Double account;
    public List<User> usersListFromDB;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    @PostConstruct
    public void init() {
        usersListFromDB = UserDatabaseOperation.getAllUsersFromDatabase();
    }

    public List<User> usersList() {
        return usersListFromDB;
    }

    public String setUser(UserBean user) {
        return UserDatabaseOperation.setUserInDatabase(user);
    }

    public String editUser(int userId) {
        return UserDatabaseOperation.editUserInDatabase(userId);
    }

    public String updateUser(UserBean user) {
        return UserDatabaseOperation.updateUserInDatabase(user);
    }

    public String deleteUser(int userId) {
        return UserDatabaseOperation.deleteUserFromDatabase(userId);
    }
}
