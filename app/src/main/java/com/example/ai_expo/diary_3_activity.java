package com.example.ai_expo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class diary_3_activity extends AppCompatActivity {
    ImageButton gotodiary;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary3);
        Intent intent = new Intent(getApplicationContext(), diary_2_activity.class);
        Intent intent_management = new Intent(getApplicationContext(), plant_mangement.class);

        gotodiary=findViewById(R.id.gotodiary);
        gotodiary.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}