package com.example.ai_expo.Dtos.PlantManagement;

public class PlantCreate {
    //토큰 사용 o
    private String plantName;
    //토큰 사용 x
    private String username;
    private String getPlantName;

    public PlantCreate(String plantName, String username, String getPlantName) {
        this.plantName = plantName;
        this.username = username;
        this.getPlantName = getPlantName;
    }
}
//string plantName
//
//토큰 사용 x
//string username
//string plantName