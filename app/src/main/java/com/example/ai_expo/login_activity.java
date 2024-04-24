package com.example.ai_expo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login_activity extends AppCompatActivity {
Button button7;
Button button4;
Button button5;
TextView user_id;
EditText editTextText;
EditText editTextTextPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = new Intent(getApplicationContext(), plant_choice.class);

        button7 = (Button) findViewById(R.id.button7);
//        button4 = (Button) findViewById(R.id.button4);
//        button5 = (Button) findViewById(R.id.button5);
//        user_id = (TextView) findViewById(R.id.user_id);
        editTextText = (EditText) findViewById(R.id.editTextText);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);


        editTextText.bringToFront();

        button7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    private void login() {
        String id = editTextText.getText().toString();
        String pw = editTextTextPassword.getText().toString();

        //LoginRequest loginRequest = new LoginRequest(id, pw);
        TokenDto tokenDto = new TokenDto(id, pw);


        ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);
        Call<TokenDto> call = serverApi.login(tokenDto);


        serverApi.login(tokenDto).enqueue(new Callback<TokenDto>() {
            @Override
            public void onResponse(Call<TokenDto> call, Response<TokenDto> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(login_activity.this, "성공하였습니다", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(login_activity.this, "로그인 실패", Toast.LENGTH_LONG).show();
                    Log.d("로그인 실패", String.valueOf(response.code()));
                }


                if (!response.isSuccessful()) {
                    Log.e("연결이 비정상적 : ", "error code : " + response.code());
                } else {
                    Utils.setAccessToken(response.body().getAccessToken());
                    Utils.setRefreshToken(response.body().getRefreshToken());
                    Log.e("Login", "at : " + Utils.getAccessToken("nein"));
                    Log.e("Login", "rt : " + Utils.getRefreshToken("none"));

                }

            }

            @Override
            public void onFailure(Call<TokenDto> call, Throwable t) {
                Toast.makeText(login_activity.this, "서버 통신 실패", Toast.LENGTH_LONG).show();
                Log.d("fail", t.getMessage());
            }
        });
    }
}