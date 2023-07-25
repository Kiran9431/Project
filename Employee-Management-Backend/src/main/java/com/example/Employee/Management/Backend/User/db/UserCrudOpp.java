package com.example.Employee.Management.Backend.User.db;

import com.example.Employee.Management.Backend.dbConnection.DbConnection;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.sql.*;

@Component(value = "userCrudOpp")
public class UserCrudOpp {


    private DbConnection dbConnection;

    public void insertData(int id, String name, String gender, String userName, String password) throws SQLException, IOException {
        String query = "insert into user_data(id,name,gender,user_name,password) \n" + "values(?,?,?,?,?)";
        Connection con= dbConnection.getConnection();
        PreparedStatement statement = con.prepareStatement(query);

        statement.setInt(1, id);
        statement.setString(2,name);
        statement.setString(3, gender);
        statement.setString(4, userName);
        statement.setString(5, password);
        statement.executeUpdate();
    }

    public ResultSet getAllUsersData() throws SQLException {
        String query = "select (id,name,gender,user_name,password) from user_data";
        Connection con= dbConnection.getConnection();
        PreparedStatement statement = con.prepareStatement(query);
        return statement.executeQuery();
    }

    public int assignRoleById(int id,String role_name) throws SQLException {
        String query=String.format("update user_data set role_name=%s where id=%s",role_name,id);
        Connection con= dbConnection.getConnection();
        PreparedStatement statement = con.prepareStatement(query);
        return statement.executeUpdate();
    }
    public int deleteUserById(int id) throws SQLException {
        String query = String.format("delete from user_data where id=%s", id);
        Connection con= dbConnection.getConnection();
        PreparedStatement statement = con.prepareStatement(query);
        return statement.executeUpdate();
    }

}
