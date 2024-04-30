package com.example.ai_expo.Dtos;

import com.google.gson.annotations.SerializedName;

public class Plant {
    @SerializedName("plantName")
    private String plantName;

    @SerializedName("plantGrowTime")
    private int plantGrowTime;

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public int getPlantGrowTime() {
        return plantGrowTime;
    }

    public void setPlantGrowTime(int plantGrowTime) {
        this.plantGrowTime = plantGrowTime;
    }

    // Getters and setters
}
