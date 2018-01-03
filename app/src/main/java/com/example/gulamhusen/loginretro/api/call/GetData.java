package com.example.gulamhusen.loginretro.api.call;

import android.content.Context;

import com.example.gulamhusen.loginretro.api.ApiInterface;
import com.example.gulamhusen.loginretro.api.model.LoginRequest;
import com.example.gulamhusen.loginretro.api.model.LoginResponce;
import com.example.gulamhusen.loginretro.api.model.User;
import com.example.gulamhusen.loginretro.helper.MyApplication;
import com.example.gulamhusen.loginretro.helper.ProgressBarHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gulamhusen on 11-04-2017.
 */

public class GetData {

    LoginRequest loginRequest;
    private OnGetData onGetData;
    private ProgressBarHelper progressBarHelper;

    public GetData(Context context, OnGetData onGetData){
        this.onGetData = onGetData;
        progressBarHelper = new ProgressBarHelper(context, false);
        call();
    }

    private void call() {
        progressBarHelper.showProgressDialog();

        ApiInterface api = MyApplication.getRetrofit().create(ApiInterface.class);
        api.get_Login(loginRequest).enqueue(new Callback<LoginResponce>() {
            @Override
            public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
                progressBarHelper.hideProgressDialog();
                if (response.body() != null){
                    onGetData.onSuccess(response.body().getData());
                }else {
                    onGetData.onFail();
                }
            }

            @Override
            public void onFailure(Call<LoginResponce> call, Throwable t) {
                progressBarHelper.hideProgressDialog();
                onGetData.onFail();
            }
        });
    }


    public interface OnGetData{
        void onSuccess(User user);

        void onFail();
    }



}
