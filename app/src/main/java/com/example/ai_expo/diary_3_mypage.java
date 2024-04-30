package com.example.ai_expo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ai_expo.Dtos.JournalDto;
import com.example.ai_expo.Dtos.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class diary_3_mypage extends AppCompatActivity {

    ImageButton gotodiary;

    TextView title;
    TextView content;
    ImageView Image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary3_mypage);
        Intent intent = new Intent(getApplicationContext(), diary_2_activity.class);
        Intent intent1 = getIntent();
        Long diaryId = intent1.getExtras().getLong("id");

        ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);

        gotodiary = findViewById(R.id.gotodiary);
        gotodiary.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        String token = getSharedPreferences("prefs", Context.MODE_PRIVATE).getAll().get("Access_Token").toString();

        serverApi.JournalSearch(Math.toIntExact(diaryId),token).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()) {
                    Post diary = response.body();

                    title = findViewById(R.id.textView7);
                    content = findViewById(R.id.textView8);
                    Image = findViewById(R.id.imageView14);

                    title.setText(diary.getTitle());
                    content.setText(diary.getContent());
                    //Image.setImageURI();
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("err",t.getMessage());
            }
        });
    }
}