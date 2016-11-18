package com.hfad.viewpager.model;

/**
 * Created by Niki on 2016-11-17.
 */

public class News {

    private String headline;
    private String summaryShort;
    private String url;
    private String publicationDate;

    public News(String headline, String summaryShort, String url, String publicationDate) {
        this.headline = headline;
        this.summaryShort = summaryShort;
        this.url = url;
        this.publicationDate = publicationDate;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummaryShort() {
        return summaryShort;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setSummaryShort(String summaryShort) {
        this.summaryShort = summaryShort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
