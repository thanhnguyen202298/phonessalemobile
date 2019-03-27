package com.aln.phonesaleschain.model;

import com.aln.phonesaleschain.gps.CurrentPosition;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HistoryTrackingResponse {
    @SerializedName("status")
    public int status;
    @SerializedName("sms")
    public String sms;
    @SerializedName("data")
    public List<CurrentPosition> dataPositionResult;

    public HistoryTrackingResponse(int status, String sms, List<CurrentPosition> dataPositionResult) {
        this.status = status;
        this.sms = sms;
        this.dataPositionResult = dataPositionResult;
    }

    public HistoryTrackingResponse() {
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

    public List<CurrentPosition> getDataPositionResult() {
        return dataPositionResult;
    }

    public void setDataPositionResult(List<CurrentPosition> dataPositionResult) {
        this.dataPositionResult = dataPositionResult;
    }
}
