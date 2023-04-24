package com.example.musicapp.model.songs.artists;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Artists {
    @SerializedName("hits")
    ArrayList<Hits> hits;
}
