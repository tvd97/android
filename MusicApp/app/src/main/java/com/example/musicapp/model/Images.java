package com.example.musicapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Images implements Serializable {
    @SerializedName("background")
    String background;
    @SerializedName("coverart")
    String coverart;
    @SerializedName("coverarthq")
    String coverarthq;
    @SerializedName("joecolor")
    String joecolor;
    @SerializedName("overflow")
    String overflow;

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getCoverart() {
        return coverart;
    }

    public void setCoverart(String coverart) {
        this.coverart = coverart;
    }

    public String getCoverarthq() {
        return coverarthq;
    }

    public void setCoverarthq(String coverarthq) {
        this.coverarthq = coverarthq;
    }

    public String getJoecolor() {
        return joecolor;
    }

    public void setJoecolor(String joecolor) {
        this.joecolor = joecolor;
    }

    public String getOverflow() {
        return overflow;
    }

    public void setOverflow(String overflow) {
        this.overflow = overflow;
    }

    public String getDefaults() {
        return defaults;
    }

    public void setDefaults(String defaults) {
        this.defaults = defaults;
    }

    @SerializedName("default")
    String defaults;
}
