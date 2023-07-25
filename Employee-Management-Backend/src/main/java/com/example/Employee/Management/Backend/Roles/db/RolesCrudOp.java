package com.example.Employee.Management.Backend.Roles.db;

import com.example.Employee.Management.Backend.dbConnection.DbConnection;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component(value = "rolesCrud")
public class RolesCrudOp {

    private DbConnection dbConnection;

    public ResultSet getAllRoles() throws SQLException {
        String query="select * from role_data";
        Connection con= dbConnection.getConnection();
        PreparedStatement statement = con.prepareStatement(query);
        return statement.executeQuery();
    }

    public ResultSet getRoleById(int id) throws SQLException {
        String query=String.format("select * from role_data where id=%s",id);
        Connection con= dbConnection.getConnection();
        PreparedStatement statement = con.prepareStatement(query);
        return statement.executeQuery();
    }
}
