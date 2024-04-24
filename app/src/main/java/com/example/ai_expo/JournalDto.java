package com.example.ai_expo;

import java.util.List;

public class JournalDto {
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
