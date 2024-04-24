package com.example.ai_expo.Dtos;

public class TokenDto {
    private String accessToken;
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    // LoginResquest

    private String username;
    private String pwd;

    public TokenDto(String username, String pwd) {
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
