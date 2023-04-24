package com.example.musicapp.model.chart.list;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Genres implements Serializable {
    @SerializedName("id")
    String id;
    @SerializedName("countryid")
    String countryid;
    @SerializedName("listid")
    String listid;
    @SerializedName("name")
    String name;
    @SerializedName("urlPath")
    String urlPath;
    @SerializedName("count")
    int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryid() {
        return countryid;
    }

    public void setCountryid(String countryid) {
        this.countryid = countryid;
    }

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
