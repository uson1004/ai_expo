package com.example.ai_expo;

import com.example.ai_expo.Dtos.JournalDto;
import com.example.ai_expo.Dtos.PlantInfoDto;
import com.example.ai_expo.Dtos.TokenDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ServerApi {
    @POST("/login")
    Call<TokenDto> login(
            //@Body LoginRequest loginRequest
            @Body TokenDto tokenDto

    );

    @POST("/register")
    Call<TokenDto> register(

    );

    // 작물관리 API

    @GET("/PlantM/GetInfo")
    Call<PlantInfoDto> GetPlantInfo(
            //@Header("authorization") String token
    );

    @POST("/plant/ai/{method}")
    Call<PlantInfoDto> GetAiSensor(

    );


    // 일기 API
    @POST("/journal/write")
    Call<JournalDto> JournalWrite(

    );

    @PATCH("/journal/update/{pageNUM}")
    Call<JournalDto> JournalUpdate(

    );

    @DELETE("/journal/delete/{pageNUM}")
    Call<JournalDto> JournalDelete(

    );

    @GET("/journal/select/{pgNum}")
    Call<JournalDto> JournalSearch(

    );

    @GET("/journal/page/{pageNUM}")
    Call<JournalDto> JournalSearchALL(

    );

    // 작물선정 API

    @POST("/pick/photo")
    Call<PlantInfoDto> PickPhoto(

    );

    @POST("/pick/insert")
    Call<PlantInfoDto> PickInsert(

    );

    @PUT("/pick/update")
    Call<PlantInfoDto> PickUpdate(

    );

    @DELETE("/pick/del")
    Call<PlantInfoDto> PickDelete(

    );
}
