package com.example.per2.myapplication;

public class Song {
    private String title;
    private String lyrics;
    private String error;
    public Song(){

    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", error='" + error + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
