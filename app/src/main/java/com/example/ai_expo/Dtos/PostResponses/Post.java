package com.example.ai_expo.Dtos.PostResponses;


import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    @SerializedName("id")
    private int id;

    @SerializedName("user")
    private User user;

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    @SerializedName("date")
    private LocalDateTime date;

    @SerializedName("file")
    private List<FileDto> files;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<FileDto> getFiles() {
        return files;
    }

    public void setFiles(List<FileDto> files) {
        this.files = files;
    }

    // Getters and setters
}
