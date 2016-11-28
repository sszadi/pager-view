package com.hfad.viewpager.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niki on 2016-11-17.
 */

public class News {

    private String headline;
    @SerializedName("summary_short")
    private String summary;
    private Link link;
    @SerializedName("publication_date")
    private String publicationDate;

    public News(String headline, String summaryShort, Link link, String publicationDate) {
        this.headline = headline;
        this.summary = summaryShort;
        this.link = link;
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

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}