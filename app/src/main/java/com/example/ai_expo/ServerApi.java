package com.example.ai_expo;

import com.example.ai_expo.Dtos.JournalDto;
import com.example.ai_expo.Dtos.JournalDtoRequest;
import com.example.ai_expo.Dtos.JournalDtoResponse;
import com.example.ai_expo.Dtos.PlantInfoDto;
import com.example.ai_expo.Dtos.PlantManagement.PlantCreate;
import com.example.ai_expo.Dtos.StringResponsesDto;
import com.example.ai_expo.Dtos.TokenDto;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ServerApi {
    @POST("/login")
    Call<TokenDto> login(
            //@Body LoginRequest loginRequest
            @Body TokenDto tokenDto

    );

    @POST("/register")
    Call<String> register(
            @Body TokenDto tokenDto
    );

    // 작물관리 API

    @GET("/PlantM/GetInfo")
    Call<PlantInfoDto> GetPlantInfo(
            @Header("authorization") String token
    );

    @GET("/plant/ai/{method}")
    Call<PlantInfoDto> GetAiSensor(
            @Header("authorization") String token
    );


    // 일기 API
    //@Multipart
    @POST("/journal/write")
    Call<StringResponsesDto> JournalWrite(
            @Header("authorization") String token,
//            @Part String title,
//            @Part String content
            @Body JournalDtoRequest journalDtoRequest
    );

    @PATCH("/journal/update/{pageNUM}")
    Call<String> JournalUpdate(
           @Body JournalDtoResponse journal
    );

    @DELETE("/journal/delete/")
    Call<JournalDto> JournalDelete(
            @Query("num") Integer num
    );

    @GET("/journal/select")
    Call<JournalDto> JournalSearch(

    );

    @GET("/journal/page")
    Call<JournalDto> JournalSearchALL(
            @Query("num") Integer s
    );

    // 작물선정 API

    @POST("/pick/photo")
    Call<PlantInfoDto> PickPhoto(

    );


    @POST("/PlantM/create")
    Call<PlantCreate> PickInsert(
            @Body PlantCreate p
    );

    @PUT("/pick/update")
    Call<PlantCreate> PickUpdate(
            @Body PlantCreate p
    );

    @DELETE("/pick/del")
    Call<String> PickDelete(
    );
}
