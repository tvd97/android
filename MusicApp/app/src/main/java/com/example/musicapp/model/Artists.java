package com.example.musicapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Artists implements Serializable {
    @SerializedName("alias")
    String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdamid() {
        return adamid;
    }

    public void setAdamid(String adamid) {
        this.adamid = adamid;
    }

    @SerializedName("id")
    String id;
    @SerializedName("adamid")
    String adamid;

}
