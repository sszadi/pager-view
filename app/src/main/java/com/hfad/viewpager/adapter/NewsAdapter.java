package com.hfad.viewpager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hfad.viewpager.R;
import com.hfad.viewpager.model.News;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{


    private List<News> news;
    private int rowLayout;
    private Context context;

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView headLine;
        TextView data;
        TextView summary;
        TextView url;

        public NewsViewHolder(View itemView) {
            super(itemView);
            headLine = (TextView) itemView.findViewById(R.id.headline);
            data = (TextView) itemView.findViewById(R.id.publication_date);
            summary = (TextView) itemView.findViewById(R.id.summary_short);
            url = (TextView) itemView.findViewById(R.id.url);

        }
    }

    public NewsAdapter(List<News> news, int rowLayout, Context context) {
        this.news = news;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, final int position) {
        holder.headLine.setText(news.get(position).getHeadline());
        holder.data.setText(news.get(position).getPublicationDate());

        holder.summary.setText(news.get(position).getSummary());
        holder.url.setText(news.get(position).getLink().getUrl());

        holder.summary.setText(news.get(position).getSummary());
        holder.url.setText(news.get(position).getLink().getUrl());

    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}
