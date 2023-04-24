package com.example.musicapp.model.chart.track;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Highlightsurls implements Serializable {
    @SerializedName("artisthighlightsurl")
    String artisthighlightsurl;

    public String getArtisthighlightsurl() {
        return artisthighlightsurl;
    }

    public void setArtisthighlightsurl(String artisthighlightsurl) {
        this.artisthighlightsurl = artisthighlightsurl;
    }

    public String getTrackhighlighturl() {
        return trackhighlighturl;
    }

    public void setTrackhighlighturl(String trackhighlighturl) {
        this.trackhighlighturl = trackhighlighturl;
    }

    @SerializedName("trackhighlighturl")
    String trackhighlighturl;
}
