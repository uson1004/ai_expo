package com.example.ai_expo.Dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.Multipart;

public class JournalDto {
    @Expose
    @SerializedName("user_id")
    private String user_id;
    private String title;
    private String content;
    //private List<String> imageUrls;


    public JournalDto(String user_id, String title, String content) {
        this.user_id = user_id;
        this.title = title;
        this.content = content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
