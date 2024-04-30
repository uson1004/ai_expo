package com.example.ai_expo.Dtos.PostResponses;

import com.example.ai_expo.Dtos.PostResponses.Plant;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("photoPath")
    private String photoPath;

    @SerializedName("plant_name")
    private Plant plantName;

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Plant getPlantName() {
        return plantName;
    }

    public void setPlantName(Plant plantName) {
        this.plantName = plantName;
    }
}
