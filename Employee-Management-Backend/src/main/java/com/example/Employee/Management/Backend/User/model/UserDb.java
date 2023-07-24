package com.example.Employee.Management.Backend.User.model;

public class UserDb {
    private int id;
    private String name;
    private String gender;
    private String roleName;
    private String userName;
    private String password;

    public UserDb() {
    }

    public UserDb(int id, String name, String gender, String userName, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
