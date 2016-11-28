package com.hfad.viewpager.rest;

import com.hfad.viewpager.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiInterface {
    @GET("reviews/search.json")
    Call<NewsResponse> getNews(@Query("api_key") String api_key);

    @GET("reviews/search.json")
    Observable<NewsResponse> getNewsRX(@Query("api_key") String api_key);

    @GET("json?address={address}&key={api_key}")
    Observable<NewsResponse> getNewsDetails(@Path("address") String address, @Query("api_key") String apiKey);


}
