package com.example.per2.myapplication;

// Maven : Add these dependecies to your pom.xml (java6+)
// <dependency>
//     <groupId>org.glassfish.jersey.core</groupId>
//     <artifactId>jersey-client</artifactId>
//     <version>2.8</version>
// </dependency>
// <dependency>
//     <groupId>org.glassfish.jersey.media</groupId>
//     <artifactId>jersey-media-json-jackson</artifactId>
//     <version>2.8</version>
// </dependency>

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText song;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        searchSong();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchSong();
            }
        });
    }

    private void searchSong() {
        String n = name.getText().toString();
        String s = song.getText().toString();

        String searchName = "https://api.lyrics.ovh/v1/" + n + "/" + s;
        Client client = ClientBuilder.newClient();
        Response response = client.target(searchName)
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get();

//        System.out.println("status: " + response.getStatus());
//        System.out.println("headers: " + response.getHeaders());
//        System.out.println("body:" + response.readEntity(String.class));

        Toast.makeText(this, response.getStatus(), Toast.LENGTH_SHORT).show();
    }

    private void wireWidgets() {
        name = findViewById(R.id.editText_MainActivity_name);
        song = findViewById(R.id.editText_MainActivity_song);
        search = findViewById(R.id.button_MainActivity_Search);
    }
}
