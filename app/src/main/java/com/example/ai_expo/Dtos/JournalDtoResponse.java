package com.example.ai_expo.Dtos;

import java.nio.channels.MulticastChannel;
import java.util.List;

import retrofit2.http.Multipart;

public class JournalDtoResponse {
    private String title;
    private String content;
    private List<Multipart> files;

    public JournalDtoResponse(String title, String content, List<Multipart> files) {
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
