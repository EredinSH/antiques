package com.antiques.antiques.database;

import com.antiques.antiques.bean.ItemBean;
import com.antiques.antiques.model.Item;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SessionScoped
public class ItemDatabaseOperation implements Serializable {

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

    public static List<Item> getAllItemsFromDatabase() {
        ArrayList itemsList = new ArrayList();
        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("SELECT * FROM antiques.item");
            while(resultSetObj.next()) {
                ItemBean itemBean = new ItemBean();
                itemBean.setId(resultSetObj.getLong("id"));
                itemBean.setName(resultSetObj.getString("name"));
                itemBean.setCategory(resultSetObj.getString("category"));
                itemBean.setYearOfProduction(resultSetObj.getInt("yearOfProduction"));
                itemBean.setPrice(resultSetObj.getDouble("price"));
                itemBean.setAuctionEndDate(resultSetObj.getDate("auctionEndDate"));
                itemBean.setDescription(resultSetObj.getString("description"));
                itemsList.add(itemBean);
            }
            System.out.println("Liczba wszystkich przedmiotów: " + itemsList.size());
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        return itemsList;
    }

    public static String setItemInDatabase() {
        int saveResult = 0;
        String navigationResult = "";
        ItemBean item = new ItemBean();
        try {
            pstmt = getConnection().prepareStatement("INSERT INTO antiques.item(name,category,yearOfProduction,price,auctionEndDate,description) VALUES (?,?,?,?,?,?)");
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getCategory());
            pstmt.setInt(3, item.getYearOfProduction());
            pstmt.setDouble(4, item.getPrice());
            pstmt.setDate(5, item.getAuctionEndDate());
            pstmt.setString(5, item.getDescription());
            saveResult = pstmt.executeUpdate();
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        if(saveResult !=0) {
            navigationResult = "itemsList.xhtml?faces-redirect=true";
        } else {
            navigationResult = "createItem.xhtml?faces-redirect=true";
        }
        return navigationResult;
    }

    public static String editItemInDatabase(int itemId) {
        ItemBean editRecord = null;
        System.out.println("editItemInDatabase() : Item Id: " + itemId);

        Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        try {
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("SELECT * from antiques.item where id = " + itemId);
            if(resultSetObj != null) {
                resultSetObj.next();
                editRecord = new ItemBean();
                editRecord.setId(resultSetObj.getLong("id"));
                editRecord.setName(resultSetObj.getString("name"));
                editRecord.setCategory(resultSetObj.getString("category"));
                editRecord.setYearOfProduction(resultSetObj.getInt("yearOfProduction"));
                editRecord.setPrice(resultSetObj.getDouble("price"));
                editRecord.setAuctionEndDate(resultSetObj.getDate("auctionEndDate"));
                editRecord.setDescription(resultSetObj.getString("description"));
            }
            sessionMapObj.put("editRecordObj", editRecord);
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        return "/editItem.xhtml?faces-redirect=true";
    }

    public static String updateItemInDatabase(ItemBean item) {
        try {
            pstmt = getConnection().prepareStatement("UPDATE antiques.item SET name=?,category=?,yearOfProduction=?,price=?,auctionEndDate=?,description=? WHERE id=?");
            pstmt.setString(1,item.getName());
            pstmt.setString(2,item.getCategory());
            pstmt.setInt(3,item.getYearOfProduction());
            pstmt.setDouble(4,item.getPrice());
            pstmt.setDate(5,item.getAuctionEndDate());
            pstmt.setString(6,item.getDescription());
            pstmt.executeUpdate();
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        return "/itemsList.xhtml?faces-redirect=true";
    }

    public static String deleteItemFromDatabase(int itemId){
        System.out.println("deleteItemFromDatabase() : Item Id: " + itemId);
        try {
            pstmt = getConnection().prepareStatement("DELETE FROM antiques.item WHERE id=" + itemId);
            pstmt.executeUpdate();
            connObj.close();
        } catch(Exception sqlException){
            sqlException.printStackTrace();
        }
        return "/itemsList.xhtml?faces-redirect=true";
    }

}
