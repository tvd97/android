package com.example.musicapp.data.remote;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitModule {
    private static Retrofit retrofit;

    private RetrofitModule() {
        retrofit = new Retrofit.Builder()
                .baseUrl(UtilsValue.URL)
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder().setLenient()
                                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                                .create()
                ))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(new OkHttpClient.Builder()
                        .readTimeout(20, TimeUnit.SECONDS)
                        .connectTimeout(2000, TimeUnit.MILLISECONDS)
                        .retryOnConnectionFailure(true)
                        .addInterceptor(
                                new HttpLoggingInterceptor()
                                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                        .addInterceptor(chain -> chain.proceed(chain.request()
                                .newBuilder().addHeader("X-RapidAPI-Key", UtilsValue.API_KEY)
                                .addHeader("X-RapidAPI-Host", UtilsValue.API_HOST)
                                .method(
                                        chain.request().method(),
                                        chain.request().body())
                                .build()))
                        .build())
                .build();
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            new RetrofitModule();
        }
        return retrofit;
    }


}
