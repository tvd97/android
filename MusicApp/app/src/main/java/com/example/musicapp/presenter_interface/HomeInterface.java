package com.example.musicapp.presenter_interface;

import com.example.musicapp.model.chart.list.ChartList;

public interface HomeInterface {
    interface View{
        void onError( Throwable e);

        void onSuccess(ChartList chartList);
    }
    interface Presenter{
        void responseApi();
    }

}
