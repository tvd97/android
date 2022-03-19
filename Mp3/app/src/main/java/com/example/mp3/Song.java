package com.example.mp3;

public class Song {
    private String Name;
    private int Url;

    public Song(String name, int url) {
        Name = name;
        Url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getUrl() {
        return Url;
    }

    public void setUrl(int url) {
        Url = url;
    }
}

