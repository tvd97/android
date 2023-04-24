package com.example.musicapp.model.chart.list;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Countries implements Serializable {
    @SerializedName("id")
    String id;
    @SerializedName("listid")
    String listid;
    @SerializedName("momentum_listid")
    String momentumListid;
    @SerializedName("name")
    String name;
    @SerializedName("cities")
    ArrayList<Cities> cities;
    @SerializedName("genres")
    ArrayList<Genres> genres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public String getMomentumListid() {
        return momentumListid;
    }

    public void setMomentumListid(String momentumListid) {
        this.momentumListid = momentumListid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Cities> getCities() {
        return cities;
    }

    public void setCities(ArrayList<Cities> cities) {
        this.cities = cities;
    }

    public ArrayList<Genres> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genres> genres) {
        this.genres = genres;
    }
}
