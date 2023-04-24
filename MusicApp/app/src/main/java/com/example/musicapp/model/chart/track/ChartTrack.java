package com.example.musicapp.model.chart.track;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ChartTrack implements Serializable {


    @SerializedName("properties")
    Properties properties;
    @SerializedName("tracks")
    ArrayList<Tracks> tracks;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setTracks(ArrayList<Tracks> tracks) {
        this.tracks = tracks;
    }

    public Properties getProperties() {
        return properties;
    }

    public ArrayList<Tracks> getTracks() {
        return tracks;
    }
}
