package com.example.ai_expo.Dtos.PostResponses;

import com.google.gson.annotations.SerializedName;

public class FileDto {

    @SerializedName("id")
    private int id;

    @SerializedName("journal")
    private int journal;

    @SerializedName("save_path")
    private String path;

    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJournal() {
        return journal;
    }

    public void setJournal(int journal) {
        this.journal = journal;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
