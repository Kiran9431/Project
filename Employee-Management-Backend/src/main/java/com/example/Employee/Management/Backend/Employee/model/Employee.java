package com.example.Employee.Management.Backend.Employee.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_data")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private long salary;

}
