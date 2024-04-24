package com.example.ai_expo;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class diary_1_activity extends AppCompatActivity {
ImageView write_icon;
ImageView wt;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary1);
        write_icon = findViewById(R.id.write_icon);
        wt = (ImageView) findViewById(R.id.wt);

        Intent intent = new Intent(getApplicationContext(), diary_2_activity.class);
        Intent intent_management = new Intent(getApplicationContext(), plant_mangement.class);
        Intent intent_diary_3 = new Intent(getApplicationContext(), diary_3_activity.class);


        write_icon.setOnClickListener(view -> startActivity(intent));

        wt.setOnClickListener(view -> startActivity(intent_diary_3));

        JournalDto journalDto = new JournalDto("", "", "");

        ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);
        Call<PlantInfoDto> call = serverApi.PickPhoto();
        // 일기 API

        //일기 작성
        serverApi.JournalWrite().enqueue(new Callback<JournalDto>() {
            @Override
            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {

            }

            @Override
            public void onFailure(Call<JournalDto> call, Throwable t) {

            }
        });

        // 일기 삭제
        serverApi.JournalDelete().enqueue(new Callback<JournalDto>() {
            @Override
            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {

            }

            @Override
            public void onFailure(Call<JournalDto> call, Throwable t) {

            }
        });

        // 일기 선택
        serverApi.JournalUpdate().enqueue(new Callback<JournalDto>() {
            @Override
            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {

            }

            @Override
            public void onFailure(Call<JournalDto> call, Throwable t) {

            }
        });

        // 일기 조회
        serverApi.JournalSearch().enqueue(new Callback<JournalDto>() {
            @Override
            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {

            }

            @Override
            public void onFailure(Call<JournalDto> call, Throwable t) {

            }
        });

        // 일기 전체 조회
        serverApi.JournalSearchALL().enqueue(new Callback<JournalDto>() {
            @Override
            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {

            }

            @Override
            public void onFailure(Call<JournalDto> call, Throwable t) {

            }
        });

        // 일기 수정하기
        serverApi.JournalUpdate().enqueue(new Callback<JournalDto>() {
            @Override
            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {

            }

            @Override
            public void onFailure(Call<JournalDto> call, Throwable t) {

            }
        });

        // 전체 일기 검색
    }
}