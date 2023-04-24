package com.example.musicapp.model.chart.track;

import com.example.musicapp.model.Artists;
import com.example.musicapp.model.Hub;
import com.example.musicapp.model.Images;
import com.example.musicapp.model.Share;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Tracks implements Serializable {
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
    @SerializedName("highlightsurls")
    Highlightsurls highlightsurls;
    @SerializedName("properties")
    Properties properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Hub getHub() {
        return hub;
    }

    public void setHub(Hub hub) {
        this.hub = hub;
    }

    public ArrayList<Artists> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artists> artists) {
        this.artists = artists;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Highlightsurls getHighlightsurls() {
        return highlightsurls;
    }

    public void setHighlightsurls(Highlightsurls highlightsurls) {
        this.highlightsurls = highlightsurls;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
