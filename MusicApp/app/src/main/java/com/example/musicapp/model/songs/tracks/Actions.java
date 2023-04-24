package com.example.musicapp.model.songs.tracks;

import com.google.gson.annotations.SerializedName;

public class Actions {
    @SerializedName("name")
    String name;
    @SerializedName("type")
    String type;
    @SerializedName("id")
    String id;
    @SerializedName("uri")
    String uri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
