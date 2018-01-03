package com.example.gulamhusen.loginretro.api;

import com.example.gulamhusen.loginretro.api.model.LoginRequest;
import com.example.gulamhusen.loginretro.api.model.LoginResponce;
import com.example.gulamhusen.loginretro.helper.ApiConstant;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by gulamhusen on 11-04-2017.
 */

public interface ApiInterface {

    @POST(ApiConstant.LOGIN)
    Call<LoginResponce> get_Login(@Body LoginRequest loginRequest);
}
