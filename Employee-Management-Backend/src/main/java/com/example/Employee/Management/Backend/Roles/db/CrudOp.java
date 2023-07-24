package com.example.Employee.Management.Backend.Roles.db;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component(value = "crudOpp")
public class CrudOp {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:://localhost:/empData";
        String userName = "root";
        String password = "";
        return DriverManager.getConnection(url, userName, password);
    }
    public ResultSet getAllRoles() throws SQLException {
        String query="select * from role_data";
        Connection con=getConnection();
        PreparedStatement statement = con.prepareStatement(query);
        return statement.executeQuery();
    }

    public ResultSet getRoleById(int id) throws SQLException {
        String query=String.format("select * from role_data where id=%s",id);
        Connection con=getConnection();
        PreparedStatement statement = con.prepareStatement(query);
        return statement.executeQuery();
    }
}
