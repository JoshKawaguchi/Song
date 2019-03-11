package com.example.per2.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RecipePuppyService {
    @GET("{artist}/{title}")
    Call<Song> searchByName(@Path("artist") String artist,@Path("title")String title);
}
