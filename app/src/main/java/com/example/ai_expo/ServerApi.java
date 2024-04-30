package com.example.ai_expo;

import com.example.ai_expo.Dtos.JournalDto;
import com.example.ai_expo.Dtos.JournalDtoResponse;
import com.example.ai_expo.Dtos.PlantInfoDto;
import com.example.ai_expo.Dtos.PlantManagement.PlantCreate;

import com.example.ai_expo.Dtos.PlantManagement.PostResponse;
import com.example.ai_expo.Dtos.Post;
import com.example.ai_expo.Dtos.TokenDto;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
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
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface ServerApi {
    @POST("/login")
    Call<ResponseBody> login(
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

    @Multipart
    @GET("/PlantM/ai")
    Call<PlantInfoDto> GetAiSensor(
            @Header("authorization") String token,
            @Part MultipartBody.Part file
            );


    // 일기 API
    @Multipart
    @POST("/journal/write")
    Call<ResponseBody> JournalWrite(
            @Header("authorization") String token,
            @PartMap Map<String, RequestBody> map
           // @Part ArrayList<MultipartBody.Part> file
    );

    @PATCH("/journal/update/{pageNUM}")
    Call<ResponseBody> JournalUpdate(
           @Body JournalDtoResponse journal
    );

    @DELETE("/journal/delete/")
    Call<ResponseBody> JournalDelete(
            @Query("num") Integer num
    );

    @GET("/journal/select")
    Call<PostResponse> JournalSearchAll(
            @Query("page") Integer p,
            @Query("size") Integer s,
            @Header("authorization") String token
    );

    @GET("/journal/page")
    Call<Post> JournalSearch(
            @Query("num") Integer s,
            @Header("authorization") String token
    );

    // 작물선정 API

    @POST("/pick/photo")
    Call<PlantInfoDto> PickPhoto(

    );

    @GET("/journal/image")
    Call<ResponseBody> getImage(
            @Query("num") Integer num,
            @Query("filenum") Integer fnum
    );

    @POST("/PlantM/create")
    Call<ResponseBody> PickInsert(
            @Body PlantCreate p
    );

    @PUT("/pick/update")
    Call<ResponseBody> PickUpdate(
            @Body PlantCreate p
    );

    @DELETE("/pick/del")
    Call<String> PickDelete(
    );
}
