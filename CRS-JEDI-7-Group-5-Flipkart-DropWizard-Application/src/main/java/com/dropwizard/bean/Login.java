package com.dropwizard.bean;

public class Login {

    private String userId;
    private String pass;
    private String role;

    public Login(String userId, String pass, String role) {
        this.userId = userId;
        this.pass = pass;
        this.role = role;
    }
    
    public Login() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
