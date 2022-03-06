package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection getConnection()
    {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            // mysql on windows : 3306
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vodafone?autoReconnect=true&useSSL=false",
                    "root", "password");
            System.out.println("DB Connected");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }
    public static Connection getConnection(String url, String driver, String username, String password)
    {

        Connection con = null;
        try {
            Class.forName(driver);
            System.out.println("Driver loaded");
            con = DriverManager.getConnection(url, username, password);

            System.out.println("DB Connected with parameters from the context");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}