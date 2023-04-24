package com.example.musicapp.data.remote;

import com.example.musicapp.model.chart.list.ChartList;
import com.example.musicapp.model.chart.track.ChartTrack;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChartService {
    @GET("/charts/list")
    Observable<ChartList> getChartList();

    @GET("/charts/track")
    Observable<ChartTrack> getCharTrack(@Query("listId") String id);
}
