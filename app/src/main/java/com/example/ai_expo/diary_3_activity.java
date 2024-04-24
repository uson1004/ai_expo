package com.example.ai_expo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class diary_3_activity extends AppCompatActivity {
    ImageButton gotodiary;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary3);
        Intent intent = new Intent(getApplicationContext(), diary_2_activity.class);
        Intent intent_management = new Intent(getApplicationContext(), plant_management.class);

        gotodiary=findViewById(R.id.gotodiary);
        gotodiary.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        JournalDto journalDto = new JournalDto("", "", "");

        //일기 API
        ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);
        Call<PlantInfoDto> call = serverApi.PickPhoto();

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
        serverApi.JournalSearchALL().enqueue(new Callback<JournalDto>() {
            @Override
            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {

            }

            @Override
            public void onFailure(Call<JournalDto> call, Throwable t) {

            }
        });

    }
}