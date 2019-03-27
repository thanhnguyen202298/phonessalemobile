package com.aln.phonesaleschain.gps;

import com.google.gson.annotations.SerializedName;

public class CurrentPosition {
//    private String tenNV;
    @SerializedName("EmpCode")
    private String maNV;
    @SerializedName("ID")
    private String id;
    @SerializedName("Latitude")
    private Double latitue;
    @SerializedName("Longitude")
    private Double longitue;
    @SerializedName("Address")
    private String address;
    @SerializedName("AtDateTime")
//    private Date date;
    private String date;

    public CurrentPosition() {

    }
    public CurrentPosition(String maNV, String id, Double latitue, Double longitue, String address, String date, String status) {
        this.maNV = maNV;
        this.id = id;
        this.latitue = latitue;
        this.longitue = longitue;
        this.address = address;
        this.date = date;
    }

    public Double getLatitue() {
        return latitue;
    }

    public Double getLongitue() {
        return longitue;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getDate() {
        return date;
    }


    public void setLatitue(Double latitue) {
        this.latitue = latitue;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLongitue(Double longitue) {
        this.longitue = longitue;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
