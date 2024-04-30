package com.example.ai_expo.Dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;

import retrofit2.http.Multipart;

public class JournalDtoResponse {

    @Expose
    @SerializedName("id")
    private int id;
    private String user_id;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("date")
    private LocalDateTime time;
    @SerializedName("file")
    private List<String> imageUrls;
    private List<Multipart> files;

    public JournalDtoResponse(int id, String user_id, String title, String content, LocalDateTime time, List imageUrls, List<Multipart> files) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.imageUrls = imageUrls;
        this.files = files;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public List<Multipart> getFiles() {
        return files;
    }

    public void setFiles(List<Multipart> files) {
        this.files = files;
    }
}
//int id
//String user_id
//string title
//string content
//localdatetime time;
//List<String> imageUrls
//List<multipartFile> files