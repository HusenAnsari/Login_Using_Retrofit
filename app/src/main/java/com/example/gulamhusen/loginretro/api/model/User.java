package com.example.gulamhusen.loginretro.api.model;

import java.io.Serializable;

/**
 * Created by gulamhusen on 11-04-2017.
 */

public class User implements Serializable{

    private String UserId;
    private String Password;
    private String Name;
    private int IsRegister;
    private String Email;
    private String Mobile;
    private int PolicyNumber;
    private String DOB;
    private String GCMToken;
    private String DeviceId;
    private String MobileOS;
    private String ImageName;
    private String ImagePath;
    private String SchemeName;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIsRegister() {
        return IsRegister;
    }

    public void setIsRegister(int isRegister) {
        IsRegister = isRegister;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public int getPolicyNumber() {
        return PolicyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        PolicyNumber = policyNumber;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
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

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getSchemeName() {
        return SchemeName;
    }

    public void setSchemeName(String schemeName) {
        SchemeName = schemeName;
    }

    public String getInsuredStatus() {
        return InsuredStatus;
    }

    public void setInsuredStatus(String insuredStatus) {
        InsuredStatus = insuredStatus;
    }

    private String InsuredStatus;


}
