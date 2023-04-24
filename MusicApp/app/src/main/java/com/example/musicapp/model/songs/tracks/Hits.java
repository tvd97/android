package com.example.musicapp.model.songs.tracks;

import com.google.gson.annotations.SerializedName;

public class Hits {
    @SerializedName("track")
    Track track;
    @SerializedName("snippet")
    String snippet;
}
