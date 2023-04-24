package com.example.musicapp.presenter_interface;

import com.example.musicapp.model.chart.track.ChartTrack;

public interface SongInterface {
    interface View {
        void onError(Throwable e);

        void onSuccess(ChartTrack tracks);
    }

    interface Presenter {
        void responseApi(String id);
    }
}
