package com.aln.phonesaleschain.model;

import com.google.gson.annotations.SerializedName;

public class ResponseSendToken {
    @SerializedName("status")
    public int status;
    @SerializedName("sms")
    public String sms;
    @SerializedName("data")
    public String data;

    public ResponseSendToken(int status, String sms, String data) {
        this.status = status;
        this.sms = sms;
        this.data = data;
    }

    public ResponseSendToken() {
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
