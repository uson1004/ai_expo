package com.example.ai_expo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class diary_2_activity extends AppCompatActivity {
ImageButton imageButton12;
ImageButton imageButton9;
ImageButton imageButton6;
ImageButton imageButton13;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary2);
        Intent intent_diary_1 = new Intent(getApplicationContext(), diary_1_activity.class);
        Intent intent_diary_3 = new Intent(getApplicationContext(), diary_3_activity.class);
        Intent intent_management = new Intent(getApplicationContext(), plant_management.class);
        Intent intent_my = new Intent(getApplicationContext(), diary_3_mypage.class);



        imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);

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
        imageButton6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent_my);
            }
        });
    }
}