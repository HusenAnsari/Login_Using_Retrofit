package com.example.gulamhusen.loginretro.api.model;

import java.util.List;

/**
 * Created by gulamhusen on 11-04-2017.
 */

public class LoginResponce {
    private User Data;
    private int ResponseCode;
    private String ResponseMessage;

    public int getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(int responseCode) {
        ResponseCode = responseCode;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        ResponseMessage = responseMessage;
    }


    public User getData() {
        return Data;
    }

    public void setData(User data) {
        Data = data;
    }
}
