package com.antiques.antiques.database;

import com.antiques.antiques.bean.UserBean;
import com.antiques.antiques.model.User;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SessionScoped
public class UserDatabaseOperation implements Serializable {
    public static Statement stmtObj;
    public static Connection connObj;
    public static ResultSet resultSetObj;
    public static PreparedStatement pstmt;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db_url = "jdbc:mysql://localhost:3306/antiques",
                    db_userName = "root",
                    db_password = "password";
            connObj = DriverManager.getConnection(db_url, db_userName, db_password);
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        return connObj;
    }

    public static List<User> getAllUsersFromDatabase() {
        ArrayList usersList = new ArrayList();
        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("SELECT * FROM antiques.user");
            while(resultSetObj.next()) {
                UserBean userBean = new UserBean();
                userBean.setId(resultSetObj.getLong("id"));
                userBean.setName(resultSetObj.getString("name"));
                userBean.setSurname(resultSetObj.getString("surname"));
                userBean.setAge(resultSetObj.getInt("age"));
                userBean.setNick(resultSetObj.getString("nick"));
                userBean.setMail(resultSetObj.getString("mail"));
                userBean.setAccount(resultSetObj.getDouble("account"));
                usersList.add(userBean);
            }
            System.out.println("Liczba wszystkich użytkowników: " + usersList.size());
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        return usersList;
    }

    public static String setUserInDatabase(UserBean user) {
        int saveResult = 0;
        String navigationResult = "";
        try {
            pstmt = getConnection().prepareStatement("INSERT INTO antiques.user(name,surname,age,nick,mail,account) VALUES (?,?,?,?,?,?)");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSurname());
            pstmt.setInt(3, user.getAge());
            pstmt.setString(4, user.getNick());
            pstmt.setString(5, user.getMail());
            pstmt.setDouble(5, user.getAccount());
            saveResult = pstmt.executeUpdate();
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        if(saveResult !=0) {
            navigationResult = "usersList.xhtml?faces-redirect=true";
        } else {
            navigationResult = "createUser.xhtml?faces-redirect=true";
        }
        return navigationResult;
    }

    public static String editUserInDatabase(int userId) {
        UserBean editRecord = null;
        System.out.println("editUserInDatabase() : User Id: " + userId);

        Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("SELECT * from antiques.user where id = " + userId);
            if(resultSetObj != null) {
                resultSetObj.next();
                editRecord = new UserBean();
                editRecord.setId(resultSetObj.getLong("id"));
                editRecord.setName(resultSetObj.getString("name"));
                editRecord.setSurname(resultSetObj.getString("surname"));
                editRecord.setAge(resultSetObj.getInt("age"));
                editRecord.setNick(resultSetObj.getString("nick"));
                editRecord.setMail(resultSetObj.getString("mail"));
                editRecord.setAccount(resultSetObj.getDouble("account"));
            }
            sessionMapObj.put("editRecordObj", editRecord);
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        return "/editUser.xhtml?faces-redirect=true";
    }

    public static String updateUserInDatabase(UserBean user) {
        try {
            pstmt = getConnection().prepareStatement("UPDATE antiques.user SET name=?,surname=?,age=?,nick=?,mail=?,account=? WHERE id=?");
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getSurname());
            pstmt.setInt(3,user.getAge());
            pstmt.setString(4,user.getNick());
            pstmt.setString(5,user.getMail());
            pstmt.setDouble(6,user.getAccount());
            pstmt.executeUpdate();
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        return "/usersList.xhtml?faces-redirect=true";
    }

    public static String deleteUserFromDatabase(int userId){
        System.out.println("deleteUserFromDatabase() : User Id: " + userId);
        try {
            pstmt = getConnection().prepareStatement("DELETE FROM antiques.user WHERE id=" + userId);
            pstmt.executeUpdate();
            connObj.close();
        } catch(Exception sqlException){
            sqlException.printStackTrace();
        }
        return "/usersList.xhtml?faces-redirect=true";
    }
}
