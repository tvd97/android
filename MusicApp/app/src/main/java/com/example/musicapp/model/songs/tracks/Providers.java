package com.example.musicapp.model.songs.tracks;

import com.example.musicapp.model.Images;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Providers {
    @SerializedName("caption")
    String caption;
    @SerializedName("images")
    Images images;
    @SerializedName("actions")
    ArrayList<Actions> actions;
    @SerializedName("type")
    String type;
}
