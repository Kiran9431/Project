package com.example.Employee.Management.Backend.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/employeeDb";
        String userName = "root";
        String password = "klsa2921";
        return DriverManager.getConnection(url, userName, password);
    }
}
