package com.example.ai_expo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ai_expo.Dtos.PlantInfoDto;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class plant_management extends AppCompatActivity {
ImageButton dlfrlwkrtjd;
TextView textdate;
TextView textHumi;
TextView textTemp;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_mangement);
        dlfrlwkrtjd = (ImageButton) findViewById(R.id.dlfrlwkrtjd);
        textdate = (TextView) findViewById(R.id.textdate);
        textHumi = (TextView) findViewById(R.id.textHumi);
        textTemp = (TextView) findViewById(R.id.textTemp);




        Intent intent_management = new Intent(getApplicationContext(), diary_3_activity.class);
        dlfrlwkrtjd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent_management);
            }
        });

        PlantInfoDto plantInfoDto = new PlantInfoDto("", "", "", "", "", 0);

        ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);
        Call<PlantInfoDto> call = serverApi.PickPhoto();
        // 작물 관리 API



        String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwiaWF0IjoxNzE0Mjc4MDk5LCJleHAiOjE3MTQzMTQwOTl9.SGyKos5S9g_hHSbqVDIXF9BJ1RHKR1uFzlp7yQQVHmQ";
        serverApi.GetPlantInfo(token).enqueue(new Callback<PlantInfoDto>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<PlantInfoDto> call, Response<PlantInfoDto> response) {
                if(response.body().getDate()!=null) {
                    Log.d("현재 토양 수분", String.valueOf(response.body().getDate()));
                    Log.d("현재 습도", String.valueOf(response.body().getHumi()));
                    Log.d("현재 온도", String.valueOf(response.body().getTemp()));

                    textdate.setText(String.valueOf(response.body().getDate()));
                    textHumi.setText(String.valueOf(response.body().getHumi()));
                    textTemp.setText(String.valueOf(response.body().getTemp()));

                    textdate.bringToFront();
                    textTemp.bringToFront();
                    textHumi.bringToFront();
                }
                else
                    Log.d("null","isnull");
            }

            @Override
            public void onFailure(Call<PlantInfoDto> call, Throwable t) {
                Log.e("fail",t.getMessage());
            }
        });

    }
}