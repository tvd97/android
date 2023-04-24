package com.example.musicapp.ui_presenter.song;

import com.example.musicapp.data.remote.ChartRepository;
import com.example.musicapp.model.chart.track.ChartTrack;
import com.example.musicapp.presenter_interface.SongInterface;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class SongPresenterImp implements SongInterface.Presenter {
    private final SongInterface.View view;
    private final ChartRepository repository;

    public SongPresenterImp(SongInterface.View view) {
        this.view = view;
        this.repository = new ChartRepository();
    }

    @Override
    public void responseApi(String id) {
        repository.getChartTrack(id).subscribe(new Observer<ChartTrack>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ChartTrack track) {
                view.onSuccess(track);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.onError(e);
            }

            @Override
            public void onComplete() {

            }
        });
    }

}
