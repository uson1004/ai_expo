package com.example.ai_expo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ai_expo.Dtos.PlantInfoDto;

import org.w3c.dom.Text;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class plant_management extends AppCompatActivity {
ImageButton dlfrlwkrtjd;
TextView textdate;
TextView textHumi;
TextView textTemp;

TextView textRate;

TextView textSituation;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_mangement);
        dlfrlwkrtjd = (ImageButton) findViewById(R.id.dlfrlwkrtjd);
        textdate = (TextView) findViewById(R.id.textdate);
        textHumi = (TextView) findViewById(R.id.textHumi);
        textTemp = (TextView) findViewById(R.id.textTemp);
        textSituation = (TextView) findViewById(R.id.textView101) ;
        textRate  = (TextView) findViewById(R.id.textView111);


        Intent intent_management = new Intent(getApplicationContext(), diary_3_activity.class);
        dlfrlwkrtjd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(intent_management);
            }
        });

        PlantInfoDto plantInfoDto = new PlantInfoDto("", "", "", "", "", 0);

        ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);
        Call<PlantInfoDto> call = serverApi.PickPhoto();
        // 작물 관리 API



        String token = getSharedPreferences("prefs", Context.MODE_PRIVATE).getAll().get("Access_Token").toString();
        serverApi.GetPlantInfo(token).enqueue(new Callback<PlantInfoDto>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<PlantInfoDto> call, Response<PlantInfoDto> response) {
                if(response.body().getDate()!=null) {
                    Log.d("현재 토양 수분", String.valueOf(response.body().getDate()));
                    Log.d("현재 습도", String.valueOf(response.body().getHumi()));
                    Log.d("현재 온도", String.valueOf(response.body().getTemp()));
                    Log.d("현재 성장도", String.valueOf(response.body().getRate()));


                    textdate.setText(String.valueOf(response.body().getDate()));
                    textHumi.setText(String.valueOf(response.body().getHumi()));
                    textTemp.setText(String.valueOf(response.body().getTemp()));

                    if(response.body().getSituation()==2){
                        textSituation.setText("작물이 정상적으로 관리되고 있습니다.");
                    }
                    textRate.setText(String.valueOf(response.body().getRate()));

                    textdate.bringToFront();
                    textTemp.bringToFront();
                    textHumi.bringToFront();
                }
                else
                    Log.d("null","isnull");
            }

            @Override
            public void onFailure(Call<PlantInfoDto> call, Throwable t) {
                Log.e("fail",t.getMessage());
            }
        });

        serverApi.rateSet(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("good","good");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}