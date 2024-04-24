package com.example.ai_expo;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

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
        Intent intent_management = new Intent(getApplicationContext(), plant_management.class);
        Intent intent_diary_3 = new Intent(getApplicationContext(), diary_3_activity.class);


        write_icon.setOnClickListener(view -> startActivity(intent));

        wt.setOnClickListener(view -> startActivity(intent_diary_3));

            }
}