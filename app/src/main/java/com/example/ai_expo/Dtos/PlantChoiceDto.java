package com.example.ai_expo.Dtos;

public class PlantChoiceDto {
    private String PlantName;

    public PlantChoiceDto(String plantName) {
        PlantName = plantName;
    }

    public String getPlantName() {
        return PlantName;
    }

    public void setPlantName(String plantName) {
        PlantName = plantName;
    }
}
