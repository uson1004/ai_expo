package com.example.ai_expo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton main_management;
    ImageButton main_write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent_diary_2 = new Intent(getApplicationContext(), diary_1_activity.class);
        Intent intent = new Intent(getApplicationContext(), plant_management.class);
        main_management = (ImageButton) findViewById(R.id.management);
        main_write = (ImageButton) findViewById(R.id.main_write);
        main_management.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent);

            }
        });
        main_write.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent_diary_2);
            }
        });
    }




}