package com.hfad.viewpager.model;

import java.util.List;

/**
 * Created by Niki on 2016-11-18.
 */

public class NewsResponse {

    private List<News> results;
    private int totalResults;

    public List<News> getResults() {
        return results;
    }

    public void setResults(List<News> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
