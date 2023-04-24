package com.example.musicapp.model.songs.tracks;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Options {
    @SerializedName("caption")
    String caption;
    @SerializedName("actions")
    ArrayList<Actions> actions;
    @SerializedName("beacondata")
    Beacondata beacondata;
    @SerializedName("image")
    String image;
    @SerializedName("type")
    String type;
    @SerializedName("listcaption")
    String listcaption;
    @SerializedName("overflowimage")
    String overflowimage;
    @SerializedName("colouroverflowimage")
    boolean colouroverflowimage;
    @SerializedName("providername")
    String providername;
}
