package com.example.Employee.Management.Backend.Roles.controller;

import com.example.Employee.Management.Backend.Roles.db.RolesCrudOp;
import com.example.Employee.Management.Backend.Roles.model.RoleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RolesCrudOp rolesCrudOp;

    @GetMapping("/getAllRoles")
    public ResponseEntity<List<Map<String, Object>>> getAllRoles() {
        try {
            List<Map<String, Object>> rolesList = new ArrayList<>();
            ResultSet resultSet = rolesCrudOp.getAllRoles();
            while (resultSet.next()) {
                Map<String, Object> role = new HashMap<>();
                role.put("id", resultSet.getInt("id"));
                role.put("name", resultSet.getString("name"));
                rolesList.add(role);
            }
            return ResponseEntity.ok(rolesList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getRoleByID/{id}")
    public  ResponseEntity<RoleDb> getRoleByID(@PathVariable(value = "id") int id){
        try{
            RoleDb roleDb=new RoleDb();
            ResultSet rs= rolesCrudOp.getRoleById(id);
            if(rs.next()){
                roleDb.setId(rs.getInt("id"));
                roleDb.setName(rs.getString("name"));
                return ResponseEntity.ok(roleDb);
            }else{
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
