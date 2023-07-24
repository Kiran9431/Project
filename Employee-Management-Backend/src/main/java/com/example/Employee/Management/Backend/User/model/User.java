package com.example.Employee.Management.Backend.User.model;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "role_name")
    private String roleName;
    @Column(name="user_name")
    private String userName;
    @Column(name = "password")
    private String password;
}
