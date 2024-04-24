package com.example.ai_expo.Dtos;

import java.util.List;

import retrofit2.http.Multipart;

public class AiPhotoResponse {
    private List<Multipart> files;

    public AiPhotoResponse(List<Multipart> files) {
        this.files = files;
    }

    public List<Multipart> getFiles() {
        return files;
    }

    public void setFiles(List<Multipart> files) {
        this.files = files;
    }
}
