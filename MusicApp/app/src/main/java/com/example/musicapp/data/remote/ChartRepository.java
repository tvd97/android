package com.example.musicapp.data.remote;

import com.example.musicapp.model.chart.list.ChartList;
import com.example.musicapp.model.chart.track.ChartTrack;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ChartRepository {
    private final ChartService service;

    public ChartRepository() {
        this.service = RetrofitModule.getInstance().create(ChartService.class);
    }

    public Observable<ChartList> getCharList() {
        return service.getChartList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ChartTrack> getChartTrack(String id) {
        return service.getCharTrack(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
