package com.antiques.antiques.manager;

import org.apache.http.annotation.Contract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Contract
public class DbManager {

    public Connection getConnection() {
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

}
