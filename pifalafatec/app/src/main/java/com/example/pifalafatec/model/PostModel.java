package com.example.pifalafatec.model;

import com.google.gson.annotations.SerializedName;

public class PostModel {
    @SerializedName("raOrEmail")
    private String raOrEmail;

    @SerializedName("password")
    private String password;

    @SerializedName("Status")
    private int status;

    @SerializedName("Status_message")
    private String status_message;

    @SerializedName("Success")
    private boolean sucess;

    public PostModel(String raOrEmail, String password) {
        this.raOrEmail = raOrEmail;
        this.password = password;
    }

    public String getRaOrEmail() {
        return raOrEmail;
    }

    public void setRaOrEmail(String raOrEmail) {
        this.raOrEmail = raOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }
}
