package com.example.ai_expo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ai_expo.Dtos.PlantInfoDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class plant_choice extends AppCompatActivity {

ImageButton choice_button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_plant_choice);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        choice_button = (ImageButton) findViewById(R.id.imageButton);

        choice_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent);
            }
        });



        PlantInfoDto plantInfoDto = new PlantInfoDto("", "", "", "", "", 0);



        ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);
        Call<PlantInfoDto> call = serverApi.PickPhoto();
        // 작물 선정 API
        serverApi.GetPlantInfo().enqueue(new Callback<PlantInfoDto>() {
            @Override
            public void onResponse(Call<PlantInfoDto> call, Response<PlantInfoDto> response) {

            }

            @Override
            public void onFailure(Call<PlantInfoDto> call, Throwable t) {

            }
        });
    }
}