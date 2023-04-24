package com.example.musicapp.model;

import com.example.musicapp.model.songs.tracks.Actions;
import com.example.musicapp.model.songs.tracks.Options;
import com.example.musicapp.model.songs.tracks.Providers;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Hub implements Serializable {
    @SerializedName("type")
    String type;
    @SerializedName("image")
    String image;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Actions> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Actions> actions) {
        this.actions = actions;
    }

    public ArrayList<Options> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Options> options) {
        this.options = options;
    }

    public ArrayList<Providers> getProviders() {
        return providers;
    }

    public void setProviders(ArrayList<Providers> providers) {
        this.providers = providers;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    @SerializedName("actions")
    ArrayList<Actions> actions;
    @SerializedName("options")
    ArrayList<Options> options;
    @SerializedName("providers")
    ArrayList<Providers> providers;
    @SerializedName("explicit")
    boolean explicit;
    @SerializedName("displayname")
    String displayname;
}
