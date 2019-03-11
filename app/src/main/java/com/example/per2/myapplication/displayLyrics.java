package com.example.per2.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class displayLyrics extends AppCompatActivity {
    private TextView lyricDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lyrics);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        wireWidgets();
        setLyrics();

    }
    private void setLyrics() {
        String lyrics = getIntent().getStringExtra(MainActivity.LYRICS);
            lyricDisplay.setText(lyrics);

    }
    private void wireWidgets() {
        lyricDisplay = findViewById(R.id.LyricDisplay);
    }
}
