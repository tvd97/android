package com.example.musicapp.model.songs;


import com.example.musicapp.model.songs.artists.Artists;
import com.example.musicapp.model.songs.tracks.Tracks;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Songs  implements Serializable {
    @SerializedName("tracks"  )
    Tracks tracks  ;
    @SerializedName("artists" )
    Artists artists ;
}
