package com.example.ai_expo.Dtos;

import retrofit2.Response;

public class StringResponsesDto {
    private Response message;

    public StringResponsesDto(Response message) {
        this.message = message;
    }

    public Response getMessage() {
        return message;
    }

    public void setMessage(Response message) {
        this.message = message;
    }
}
