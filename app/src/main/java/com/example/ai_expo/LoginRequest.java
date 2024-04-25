package com.example.ai_expo;

public class LoginRequest {


    private String username;
    private String pwd;

    public LoginRequest(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }
}
