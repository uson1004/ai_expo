package com.example.ai_expo;

import static com.example.ai_expo.R.id.management;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class plant_mangement extends AppCompatActivity {
ImageButton dlfrlwkrtjd;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_mangement);
        dlfrlwkrtjd = (ImageButton) findViewById(R.id.dlfrlwkrtjd);

        Intent intent_management = new Intent(getApplicationContext(), diary_3_activity.class);
        dlfrlwkrtjd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent_management);

            }
        });

        PlantInfoDto plantInfoDto = new PlantInfoDto("", "", "", "", "", 0);

        ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);
        Call<PlantInfoDto> call = serverApi.PickPhoto();
//        // 작물 관리 API
//        serverApi.GetAiSensor().enqueue(new Callback<PlantInfoDto>() {
//            @Override
//            public void onResponse(Call<PlantInfoDto> call, Response<PlantInfoDto> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<PlantInfoDto> call, Throwable t) {
//
//            }
//        });
    }
}