package com.hfad.viewpager.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hfad.viewpager.MainActivity;
import com.hfad.viewpager.R;
import com.hfad.viewpager.adapter.NewsAdapter;
import com.hfad.viewpager.model.Geometry;
import com.hfad.viewpager.model.GeometryResponse;
import com.hfad.viewpager.model.News;
import com.hfad.viewpager.model.NewsResponse;
import com.hfad.viewpager.rest.ApiClient;
import com.hfad.viewpager.rest.ApiInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FirstFragment extends Fragment {

    private static final String API_KEY = "6cd5301171754be7959375a986f18b14";
    public static final String BASE_URL = "https://api.nytimes.com/svc/movies/v2/reviews/";

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout mainLayout = (RelativeLayout) inflater.inflate(R.layout.fragment1_layout, container, false);
        recyclerView = (RecyclerView) mainLayout.findViewById(R.id.recycler_view);

        ButterKnife.bind(this, mainLayout);

        if (API_KEY.isEmpty()) {
            Toast.makeText(inflater.getContext(), "Please obtain your API KEY first", Toast.LENGTH_SHORT).show();
        }
        progress.setVisibility(View.VISIBLE);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ApiClient apiClient = new ApiClient(BASE_URL);
        ApiInterface apiService = apiClient.getClient().create(ApiInterface.class);

        apiService.getNewsRX(API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(MainActivity.class.getSimpleName(), e.getMessage());
                    }

                    @Override
                    public void onNext(NewsResponse newsResponse) {
                        progress.setVisibility(View.GONE);
                        List<News> news = newsResponse.getResults();
                        recyclerView.setAdapter(new NewsAdapter(news, R.layout.list_news_layout, getContext()));
                    }
                });

        return mainLayout;
    }

}
