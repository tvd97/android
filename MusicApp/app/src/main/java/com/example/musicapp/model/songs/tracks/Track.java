package com.example.musicapp.model.songs.tracks;

import com.example.musicapp.model.Artists;
import com.example.musicapp.model.Hub;
import com.example.musicapp.model.Images;
import com.example.musicapp.model.Share;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Track {
    @SerializedName("layout")
    String layout;
    @SerializedName("type")
    String type;
    @SerializedName("key")
    String key;
    @SerializedName("title")
    String title;
    @SerializedName("subtitle")
    String subtitle;
    @SerializedName("share")
    Share share;
    @SerializedName("images")
    Images images;
    @SerializedName("hub")
    Hub hub;
    @SerializedName("artists")
    ArrayList<Artists> artists;
    @SerializedName("url")
    String url;
}
