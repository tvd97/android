package com.example.musicapp.model.chart.list;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Global implements Serializable {
    @SerializedName("genres" )
    ArrayList<Genres> genres ;

    public ArrayList<Genres> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genres> genres) {
        this.genres = genres;
    }
}
