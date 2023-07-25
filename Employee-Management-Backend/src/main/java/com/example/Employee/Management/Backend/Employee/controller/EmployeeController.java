package com.example.Employee.Management.Backend.Employee.controller;

import com.example.Employee.Management.Backend.Employee.db.EmployeeCrudOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeCrudOp employeeCrudOp;
    @PostMapping("/createEmp")
    public ResponseEntity<String> createEmployee(@RequestBody Map<String,Object> record) {
        try {
            int id = (int) record.get("id");
            String name = (String) record.get("name");
            String gender = (String) record.get("gender");
            String department = (String) record.get("department");
            long salary = (int) record.get("salary");
            employeeCrudOp.insertData(id, name, gender, department, salary);
            return ResponseEntity.ok("Employee added successfully");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    @DeleteMapping("/deleteEmp/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
        try {
            int deletedRows= employeeCrudOp.deleteEmployeeById(id);
            if (deletedRows>0){
                return ResponseEntity.ok("Employee deleted");
            }else {
                return ResponseEntity.ok("Employee not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Map<String,Object>> getEmployee(@PathVariable("id") int id)  {
        try {
            ResultSet resultSet = employeeCrudOp.getEmployeeDataByID(id);
            if (resultSet.next()){
                Map<String,Object> data=new HashMap<>();
                data.put("id",resultSet.getInt("id"));
                data.put("name",resultSet.getString("name"));
                data.put("gender",resultSet.getString("gender"));
                data.put("department",resultSet.getString("department"));
                data.put("salary",resultSet.getLong("salary"));
                return ResponseEntity.ok(data);
            }else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Map<String,Object>>> getAllEmployees(){
        try {
            List<Map<String,Object>> employeeList=new ArrayList<>();
            ResultSet resultSet= employeeCrudOp.getAllEmployeesData();
            while (resultSet.next()){
                Map<String, Object> employee=new HashMap<>();
                employee.put("id",resultSet.getInt("id"));
                employee.put("name",resultSet.getString("name"));
                employee.put("gender",resultSet.getString("gender"));
                employee.put("department",resultSet.getString("department"));
                employee.put("salary",resultSet.getLong("salary"));
                employeeList.add(employee);
            }
            return ResponseEntity.ok(employeeList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") int id,@RequestBody Map<String,Object> data){
        try{
            int numberOfUpdatedRecords=0;
            for (String key: data.keySet()) {
                numberOfUpdatedRecords= employeeCrudOp.updateEmployeeDataById(id,key, data.get(key));
            }
            if (numberOfUpdatedRecords>0){
                return ResponseEntity.ok("Data updated");
            }else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
