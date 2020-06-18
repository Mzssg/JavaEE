package com.example.springbootdemo.model;

public class loginmodel {
    private String username;
   private String password;
    private int type;

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public int gettype() {
        return type;
    }

    public void settype(int type) {
        this.type = type;
    }
}
