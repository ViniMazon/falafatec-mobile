package com.example.pifalafatec.model;

import com.google.gson.annotations.SerializedName;

public class PostModel {

    public PostModel() {
    }

    @SerializedName("raOrEmail")
    private String raOrEmail;

    @SerializedName("password")
    private String password;

    @SerializedName("Status")
    private int Status;

    @SerializedName("Success")
    private boolean Success;

    @SerializedName("Status_Message")
    private String Status_Message;

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
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getStatus_Message() {
        return Status_Message;
    }

    public void setStatus_Message(String status_Message) {
        Status_Message = status_Message;
    }
}
