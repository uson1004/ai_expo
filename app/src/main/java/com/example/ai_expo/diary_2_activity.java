package com.example.ai_expo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;


import com.example.ai_expo.Dtos.Post;
import com.example.ai_expo.Dtos.PlantManagement.PostResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// 동적으로 페이지 생성하기.

public class diary_2_activity extends AppCompatActivity {
ImageButton imageButton12;
ImageButton imageButton9;
ImageButton imageButton6;
ImageButton imageButton13;
ImageButton imageButton17;

ImageButton imageButton11;

RecyclerView diaryRecycler;
DiaryAdapter diaryAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary2);
        Intent intent_diary_1 = new Intent(getApplicationContext(), diary_1_activity.class);
        Intent intent_diary_3 = new Intent(getApplicationContext(), diary_3_activity.class);
        Intent intent_management = new Intent(getApplicationContext(), plant_management.class);
        Intent main = new Intent(getApplicationContext(), MainActivity.class);

        diaryRecycler = findViewById(R.id.diaryRecycler);



        diaryRecycler.setLayoutManager(new LinearLayoutManager(this));


        imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        //imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        //imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        imageButton11 = (ImageButton) findViewById(R.id.imageButton11);



        ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);

        String token = getSharedPreferences("prefs", Context.MODE_PRIVATE).getAll().get("Access_Token").toString();


        serverApi.JournalSearchAll(0,5, token).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                assert response.body() != null;
                if(!response.body().isEmpty()) {
                    for (Post p : response.body().getPosts()) {
                        Log.d("log", p.getContent());
                        Log.d("log", p.getTitle());
                        Log.d("log", String.valueOf(p.getId()));

                        Log.d("log", String.valueOf(p.getFiles().isEmpty()));
                    }
                    diaryAdapter = new DiaryAdapter(response.body().getPosts());
                    diaryRecycler.setAdapter(diaryAdapter);


                    Log.e("look",response.body().getPosts().toString());
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Log.e("err",t.getMessage());
            }
        });
//
//        serverApi.JournalSearch(80).enqueue(new Callback<JournalDto>() {
//            @Override
//            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<JournalDto> call, Throwable t) {
//
//            }
//        });

//        serverApi.getImage(80,1).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                 Log.e("image","ok");
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });


        imageButton12.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent_diary_1);
            }
        });

        imageButton9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                startActivity(intent_diary_3);
            }
        });
        imageButton13.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent_management);
            }
        });

        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(main);
            }
        });
//        imageButton6.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view) {
//                startActivity(intent_diary_3My);
//            }
//        });
    }
}