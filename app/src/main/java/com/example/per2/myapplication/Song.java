package com.example.per2.myapplication;

public class Song {
    private String title;
    private String lyrics;

    public Song(){

    }
    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }



    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", lyrics='" + lyrics + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
