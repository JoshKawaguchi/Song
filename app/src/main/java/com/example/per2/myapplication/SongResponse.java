package com.example.per2.myapplication;

import java.util.List;

public class SongResponse {
    private String lyrics;
    private String error;

    public SongResponse(){}
    public String getLyrics() {
        return lyrics;
    }

    public String getError(){
        return error;
    }
    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
