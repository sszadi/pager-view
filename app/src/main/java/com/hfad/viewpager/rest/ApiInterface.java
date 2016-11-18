package com.hfad.viewpager.rest;

import com.hfad.viewpager.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Niki on 2016-11-18.
 */

public interface ApiInterface {
    @GET("reviews/search.json")
    Call<NewsResponse> getNews (@Query("api_key") String api_key);

    @GET("news/{headline}")
    Call<NewsResponse> getNewsDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
