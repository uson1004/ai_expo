package com.example.ai_expo;

import static java.time.LocalDateTime.now;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.ai_expo.Dtos.JournalDto;
import com.example.ai_expo.Dtos.JournalDtoRequest;
import com.example.ai_expo.Dtos.JournalDtoResponse;
import com.example.ai_expo.Dtos.PlantInfoDto;
import com.example.ai_expo.Dtos.StringResponsesDto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Header;
import retrofit2.http.Part;

public class diary_3_activity extends AppCompatActivity {
    ImageButton gotodiary;
    EditText editTextText2;
    EditText editTextText3;
    Button button2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary3);
        Intent intent = new Intent(getApplicationContext(), diary_2_activity.class);
        Intent intent_management = new Intent(getApplicationContext(), plant_management.class);

        gotodiary = findViewById(R.id.gotodiary);
        editTextText2 = (EditText) findViewById(R.id.editTextText2);
        editTextText3 = (EditText) findViewById(R.id.editTextText3);
        button2 = (Button) findViewById(R.id.button2);





        gotodiary.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        //JournalDto journalDto = new JournalDto("", "", "");
        //JournalDtoResponse journalDtoResponse = new JournalDtoResponse(0, "", "", "", now(), new ArrayList<String>(), null);





        LocalTime time = LocalTime.from(now());
        //일기 API
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);
                Call<PlantInfoDto> call = serverApi.PickPhoto();


                String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwiaWF0IjoxNzE0MjY5MDcxLCJleHAiOjE3MTQzMDUwNzF9.hurtFetmiP3Y8BDvv9LpCPbXzjxZmlMwzJr6CR4ifWo";

                String title = editTextText2.getText().toString();
                String content = editTextText3.getText().toString();


                Log.e("fdf",title);
                Log.e("dfdf",content);

                Map<String, RequestBody> map = new HashMap<>();
                RequestBody titles = RequestBody.create(MediaType.parse("text/plain"),title);
                RequestBody contents = RequestBody.create(MediaType.parse("text/plain"),content);


                map.put("title",titles);
                map.put("content",contents);

                //일기 작성
                serverApi.JournalWrite(token,map).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.d("result", String.valueOf(response.headers()));
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("err", t.getMessage());
//                        Log.d("title",title);
//                        Log.d("content",content);
                        Log.d("test",editTextText2.getText().toString());
                    }
                });

//                serverApi.GetAiSensor(token,).enqueue(new Callback<PlantInfoDto>() {
//                    @Override
//                    public void onResponse(Call<PlantInfoDto> call, Response<PlantInfoDto> response) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<PlantInfoDto> call, Throwable t) {
//
//                    }
//                });
            }
        });

        // 일기 삭제
//        serverApi.JournalDelete().enqueue(new Callback<JournalDto>() {
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

        // 일기 선택
//        serverApi.JournalUpdate().enqueue(new Callback<JournalDto>() {
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

//        // 일기 조회
//        ServerApi.().enqueue(new Callback<JournalDto>() {
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
//
//        // 일기 전체 조회
//        serverApi.JournalSearchALL().enqueue(new Callback<JournalDto>() {
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
//
//        // 일기 수정하기
////        serverApi.JournalUpdate().enqueue(new Callback<JournalDto>() {
////            @Override
////            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {
////
////            }
////
////            @Override
////            public void onFailure(Call<JournalDto> call, Throwable t) {
////
////            }
////        });
//
//        // 전체 일기 검색
//        serverApi.JournalSearchALL().enqueue(new Callback<JournalDto>() {
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
//
//    }

    }


}