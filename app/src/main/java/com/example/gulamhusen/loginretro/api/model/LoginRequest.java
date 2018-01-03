package com.example.gulamhusen.loginretro.api.model;

/**
 * Created by gulamhusen on 11-04-2017.
 */

public class LoginRequest {
    private String Password;
    private int IsRegister;
    private String Mobile;
    private String GCMToken;
    private String DeviceId;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getIsRegister() {
        return IsRegister;
    }

    public void setIsRegister(int isRegister) {
        IsRegister = isRegister;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getGCMToken() {
        return GCMToken;
    }

    public void setGCMToken(String GCMToken) {
        this.GCMToken = GCMToken;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public String getMobileOS() {
        return MobileOS;
    }

    public void setMobileOS(String mobileOS) {
        MobileOS = mobileOS;
    }

    private String MobileOS;

}
