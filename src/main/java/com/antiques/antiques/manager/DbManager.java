package com.antiques.antiques.manager;

import com.antiques.antiques.model.Item;
import com.antiques.antiques.model.User;
import org.apache.http.annotation.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Contract
public class DbManager {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database",
                    "root",
                    "password");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static int addUser(User user) throws SQLException {
        int result = 0;
        Connection conn = DbManager.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("insert into user(name,surname,age,nick,mail,account) values (?,?,?,?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setInt(3, user.getAge());
        preparedStatement.setString(4, user.getNick());
        preparedStatement.setString(5, user.getMail());
        preparedStatement.setDouble(6, user.getAccount());

        result = preparedStatement.executeUpdate();
        conn.close();
        return result;
    }

    public static int updateUser(User user) throws SQLException {
        int result = 0;
        Connection conn = DbManager.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("update user set name=?,surname=?,age=?,nick=?,mail=?,account=? where id=?");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setInt(3, user.getAge());
        preparedStatement.setString(4, user.getNick());
        preparedStatement.setString(5, user.getMail());
        preparedStatement.setDouble(6, user.getAccount());

        result = preparedStatement.executeUpdate();
        conn.close();
        return result;
    }

    public static int deleteUser(int id) throws SQLException {
        int result = 0;
        Connection conn = DbManager.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("delete from user where id=?");
        preparedStatement.setInt(1, id);

        result = preparedStatement.executeUpdate();
        conn.close();
        return result;
    }

    public static User getUserById(int id) throws SQLException {
        User user = new User();
        Connection conn = DbManager.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from user where id=?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet
                = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));
            user.setNick(resultSet.getString(5));
            user.setMail(resultSet.getString(6));
            user.setAccount(resultSet.getDouble(7));
        }

        conn.close();
        return user;
    }

    public static List<User> getAllUsers() throws SQLException {
        List<User> list = new ArrayList<>();
        Connection conn = DbManager.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));
            user.setNick(resultSet.getString(5));
            user.setMail(resultSet.getString(6));
            user.setAccount(resultSet.getDouble(7));
            list.add(user);
        }

        conn.close();
        return list;
    }


    public static int addItem(Item item) throws SQLException {
        int result = 0;
        Connection conn = DbManager.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("insert into item(name,category,yearOfProduction,price,auctionEndDate,description) values (?,?,?,?,?,?)");
        preparedStatement.setString(1, item.getName());
        preparedStatement.setString(2, item.getCategory());
        preparedStatement.setInt(3, item.getYearOfProduction());
        preparedStatement.setDouble(4, item.getPrice());
        preparedStatement.setDate(5, item.getAuctionEndDate());
        preparedStatement.setString(6, item.getDescription());

        result = preparedStatement.executeUpdate();
        conn.close();
        return result;
    }

    public static int updateItem(Item item) throws SQLException {
        int result = 0;
        Connection conn = DbManager.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("update item set name=?,category=?,yearOfProduction=?,price=?,auctionEndDate=?,description=? where id=?");
        preparedStatement.setString(1, item.getName());
        preparedStatement.setString(2, item.getCategory());
        preparedStatement.setInt(3, item.getYearOfProduction());
        preparedStatement.setDouble(4, item.getPrice());
        preparedStatement.setDate(5, item.getAuctionEndDate());
        preparedStatement.setString(6, item.getDescription());

        result = preparedStatement.executeUpdate();
        conn.close();
        return result;
    }

    public static int deleteItem(int id) throws SQLException {
        int result = 0;
        Connection conn = DbManager.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("delete from item where id=?");
        preparedStatement.setInt(1, id);

        result = preparedStatement.executeUpdate();
        conn.close();
        return result;
    }

    public static Item getItemById(int id) throws SQLException {
        Item item = new Item();
        Connection conn = DbManager.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from item where id=?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet
                = preparedStatement.executeQuery();
        if (resultSet.next()) {
            item.setId(resultSet.getInt(1));
            item.setName(resultSet.getString(2));
            item.setCategory(resultSet.getString(3));
            item.setYearOfProduction(resultSet.getInt(4));
            item.setPrice(resultSet.getDouble(5));
            item.setAuctionEndDate(resultSet.getDate(6));
            item.setDescription(resultSet.getString(7));
        }

        conn.close();
        return item;
    }

    public static List<Item> getAllItems(int start, int total) throws SQLException {
        List<Item> list = new ArrayList<>();
        Connection conn = DbManager.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from item limit " + (start -1) + "," + total);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            Item item = new Item();
            item.setId(resultSet.getInt(1));
            item.setName(resultSet.getString(2));
            item.setCategory(resultSet.getString(3));
            item.setYearOfProduction(resultSet.getInt(4));
            item.setPrice(resultSet.getDouble(5));
            item.setAuctionEndDate(resultSet.getDate(6));
            item.setDescription(resultSet.getString(7));
            list.add(item);
        }

        conn.close();
        return list;
    }

}
