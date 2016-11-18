package com.hfad.viewpager.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hfad.viewpager.MainActivity;
import com.hfad.viewpager.R;
import com.hfad.viewpager.adapter.NewsAdapter;
import com.hfad.viewpager.model.News;
import com.hfad.viewpager.model.NewsResponse;
import com.hfad.viewpager.rest.ApiClient;
import com.hfad.viewpager.rest.ApiInterface;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String API_KEY = "6cd5301171754be7959375a986f18b14";
    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment1_layout, container, false);

        if (API_KEY.isEmpty()) {
            Toast.makeText(inflater.getContext(), "Please obtain your API KEY first", Toast.LENGTH_SHORT).show();
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<NewsResponse> call = apiService.getNews(API_KEY);

        call.enqueue(new Callback<NewsResponse>() {

            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                int code = response.code();
                List<News> news = response.body().getResults();
                recyclerView.setAdapter(new NewsAdapter(news, R.layout.list_news_layout, getContext()));

s            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
        return recyclerView;
    }

}
