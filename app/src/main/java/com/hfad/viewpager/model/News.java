package com.hfad.viewpager.model;

/**
 * Created by Niki on 2016-11-17.
 */

public class News {

    private String headline;
    private String summary;
    private String url;
    private String publicationDate;

    public News(String headline, String summary, String url, String publicationDate) {
        this.headline = headline;
        this.summary = summary;
        this.url = url;
        this.publicationDate = publicationDate;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSummary() {
        return summary;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getUrl() {
        return url;
    }
}
