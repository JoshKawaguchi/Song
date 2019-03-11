package com.example.per2.myapplication;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText song;
    private Button search;
    public static final String LYRICS = "lyrics";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchSong();
            }
        });
        }

    private void searchSong() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.lyrics.ovh/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RecipePuppyService service = retrofit.create(RecipePuppyService.class);
        Call<Song> lyricResponseCall = service.searchByName(name.getText().toString(), song.getText().toString());

        lyricResponseCall.enqueue(new Callback<Song>() {
            @Override
            public void onResponse(Call<Song> call, Response<Song> response) {
                Intent Lyrics = new Intent(MainActivity.this,
                        displayLyrics.class);

                String lyrics = response.body().getLyrics().toString();

                Lyrics.putExtra(LYRICS, lyrics);
                startActivity(Lyrics);

            }

            @Override
            public void onFailure(Call<Song> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
            }
        });
    }

    private void wireWidgets() {
        name = findViewById(R.id.editText_MainActivity_name);
        song = findViewById(R.id.editText_MainActivity_song);
        search = findViewById(R.id.button_MainActivity_Search);
    }
}
