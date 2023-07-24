package com.example.Employee.Management.Backend.Employee.db;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;

@Component("crudOpp")
public class CrudOp {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:://localhost:/empData";
        String userName = "root";
        String password = "";
        return DriverManager.getConnection(url, userName, password);
    }
    public void insertData(int employeeID, String name, String gender, String department, long salary) throws SQLException, IOException {
        String query = "insert into employee_data(id,name,gender,department,salary) \n" + "values(?,?,?,?,?)";
        Connection connection = this.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, employeeID);
        statement.setString(2,name);
        statement.setString(3, gender);
        statement.setString(4, department);
        statement.setLong(5, salary);

        statement.executeUpdate();
    }

    public ResultSet getAllEmployeesData() throws SQLException {
        String query = "select*from employee_data";
        Connection con = this.getConnection();
        PreparedStatement statement = con.prepareStatement(query);
        return statement.executeQuery();
    }

    public ResultSet getEmployeeDataByID(int employeeID) throws SQLException {
        String query = String.format("select*from employee_data where employeeID=%s", employeeID);
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement(query);
        return statement.executeQuery();
    }

    public int updateEmployeeDataById(int employeeID,String field,Object value) throws SQLException {
        String query;

        if (field.equalsIgnoreCase("salary")){
            String sa=value.toString();
            query=String.format("update employee_data set salary=%s where employeeID=%s",Long.parseLong(sa),employeeID);
        }else {
            query=String.format("update employee_data set %s='%s' where employeeID=%s",field,value,employeeID);
        }
        Connection con=getConnection();
        PreparedStatement statement=con.prepareStatement(query);
        return statement.executeUpdate();
    }

    public int deleteEmployeeById(int employeeID) throws SQLException {
        String query = String.format("delete from employee_data where employeeID=%s", employeeID);
        Connection connection = this.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeUpdate();
    }
}