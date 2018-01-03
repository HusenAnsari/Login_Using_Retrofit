package com.example.gulamhusen.loginretro.helper;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gulamhusen on 11-04-2017.
 */

public class MyApplication extends Application{
    private static Gson gson;
    private static Retrofit retrofit;
    private float a =  6.1f;
    int i = Math.round(a);
    @Override
    public void onCreate() {
        super.onCreate();
        initGson();
        initRetrofit();
        System.out.print(i);
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static Gson getGson() {
        return gson;
    }

    private void initRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


    }

    private void initGson() {
        gson = new GsonBuilder()
                .setLenient()
                .create();
    }
}
