package com.example.musicapp.data.remote;

import com.example.musicapp.model.songs.Songs;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface SongService {
    @GET("/songs/get-count")
    Observable<Songs> getCountSong();

}
