package com.antiques.antiques.bean;

import com.antiques.antiques.manager.DbManager;
import com.antiques.antiques.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@ManagedBean
@SessionScoped
public class DbManagerBean implements Serializable  {

    @ManagedProperty(value="dbManagerBean")
    private DbManager dbManager;

    public List<User> getUsersList() throws SQLException {
        return DbManager.getAllUsers();
    }

    public int editUser(User user) throws SQLException {
        return DbManager.updateUser(user);
    }

    public int deleteUSer(int id) throws SQLException {
        return DbManager.deleteUser(id);
    }
}
