package com.hfad.viewpager.model;

/**
 * Created by Mohru on 22.11.2016.
 */

public class Link {

    public String type;
    public String url;


    public Link(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
