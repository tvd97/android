package com.example.musicapp.model.songs.artists;

import com.google.gson.annotations.SerializedName;

public class Artist {
    @SerializedName("avatar")
    String avatar;
    @SerializedName("name")
    String name;
    @SerializedName("verified")
    boolean verified;
    @SerializedName("weburl")
    String weburl;
    @SerializedName("adamid")
    String adamid;
}
