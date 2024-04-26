package com.example.ai_expo.Dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

import retrofit2.http.Multipart;

public class JournalDtoRequest {
    @Expose
    private String title;
    @Expose
    private String content;
    @Expose
    private List<Multipart> files;

    public JournalDtoRequest(String title, String content, List<Multipart> files) {
        this.title = title;
        this.content = content;
        this.files = files;
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

    public List<Multipart> getFiles() {
        return files;
    }

    public void setFiles(List<Multipart> files) {
        this.files = files;
    }
}
