package com.aln.phonesaleschain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseLastPositionModel {
    @SerializedName("status")
    public int status;
    @SerializedName("sms")
    public String sms;
    @SerializedName("data")
    public List<StatusNhanVien> dataLastPosition;

    public ResponseLastPositionModel(int status, String sms, List<StatusNhanVien> dataLastPosition) {
        this.status = status;
        this.sms = sms;
        this.dataLastPosition = dataLastPosition;
    }

    public ResponseLastPositionModel() {
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

    public List<StatusNhanVien> getDataLastPosition() {
        return dataLastPosition;
    }

    public void setDataLastPosition(List<StatusNhanVien> dataLastPosition) {
        this.dataLastPosition = dataLastPosition;
    }
}
