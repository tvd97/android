package com.example.musicapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Share implements Serializable {
    @SerializedName("subject")
    String subject;
    @SerializedName("text")
    String text;
    @SerializedName("href")
    String href;
    @SerializedName("image")
    String image;
    @SerializedName("twitter")
    String twitter;
    @SerializedName("html")
    String html;
    @SerializedName("avatar")
    String avatar;
    @SerializedName("snapchat")
    String snapchat;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSnapchat() {
        return snapchat;
    }

    public void setSnapchat(String snapchat) {
        this.snapchat = snapchat;
    }


}
