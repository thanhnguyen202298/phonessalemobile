package com.aln.phonesaleschain.model;

import com.google.gson.annotations.SerializedName;

public class ResponseSavePosition {
    @SerializedName("status")
    private int status;
    @SerializedName("sms")
    private String sms;
    @SerializedName("data")
    private String data;

    public ResponseSavePosition(int status, String sms, String data) {
        this.status = status;
        this.sms = sms;
        this.data = data;
    }

    public ResponseSavePosition() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
