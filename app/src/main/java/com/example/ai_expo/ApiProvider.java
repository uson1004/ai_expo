package com.example.ai_expo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {
    private static Retrofit instance;
    private static String BASE_URL = "http://192.168.137.238:8080";



    public static Retrofit getInstance() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return instance;
    }
}
