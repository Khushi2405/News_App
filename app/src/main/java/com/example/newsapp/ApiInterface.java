package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<mainAPIClass> getNews(
        @Query("country") String country,
        @Query("pageSize") int pageSize,
        @Query("apiKey") String api
    );
    @GET("top-headlines")
    Call<mainAPIClass> getCategoryNews(
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String api,
            @Query("category") String category
    );
}
