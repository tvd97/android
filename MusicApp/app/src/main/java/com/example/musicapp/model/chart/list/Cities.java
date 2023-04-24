package com.example.musicapp.model.chart.list;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cities implements Serializable {

    @SerializedName("id")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @SerializedName("name")
    String name;
    @SerializedName("countryid")
    String countryid;
    @SerializedName("listid")
    String listid;
}
