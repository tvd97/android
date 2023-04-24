package com.example.musicapp.ui_presenter.home;

import com.example.musicapp.data.remote.ChartRepository;
import com.example.musicapp.model.chart.list.ChartList;
import com.example.musicapp.presenter_interface.HomeInterface;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class HomePresenterImp implements HomeInterface.Presenter {
    private final ChartRepository repository;

    private final HomeInterface.View view;

    public HomePresenterImp(HomeInterface.View view) {
        this.view = view;
        this.repository = new ChartRepository();
    }

    @Override
    public void responseApi() {
        repository.getCharList().subscribe(new Observer<ChartList>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ChartList list) {
                view.onSuccess(list);
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