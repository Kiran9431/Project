package com.example.Employee.Management.Backend.Roles.model;

import javax.persistence.*;

@Entity
@Table(name = "role_data")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
}
