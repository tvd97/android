package com.example.musicapp;

import com.example.musicapp.model.chart.track.Tracks;

import java.util.ArrayList;

//general data using in service, list song online/offline, play fragment
public class General {
    public static class Actions {
        public static final String ACTION_PREVIOUS = "ACTION_PREVIOUS";
        public static final String ACTION_PLAY = "ACTION_PLAY";
        public static final String ACTION_NEXT = "ACTION_NEXT";
        public static final String ACTION_PAUSE = "ACTION_PAUSE";
        public static final String MEDIA_TAG = "MEDIA_TAG";
        public static final String CHANNEL_ID = "CHANNEL_ID";
    }

    public static class ListSong {
        public static ArrayList<Tracks> list = new ArrayList<>();
        public static int position = 0;
    }
}
