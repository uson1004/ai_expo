package com.example.ai_expo;

public class PlantInfoDto {
    private String plantName;
    private String date;
    private String temp;
    private String humi;
    private String rate;
    private int situation;

    public PlantInfoDto(String plantName, String date, String temp, String humi, String rate, int situation) {
        this.plantName = plantName;
        this.date = date;
        this.temp = temp;
        this.humi = humi;
        this.rate = rate;
        this.situation = situation;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumi() {
        return humi;
    }

    public void setHumi(String humi) {
        this.humi = humi;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }
}
