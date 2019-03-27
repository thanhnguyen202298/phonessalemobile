package com.aln.phonesaleschain.model;

import com.google.gson.annotations.SerializedName;

public class StatusNhanVien {
    @SerializedName("EmpCode")
    private String maNV;
    @SerializedName("EmpName")
    private String tenNV;
    @SerializedName("DivisionName")
    private String divisionName;
    @SerializedName("Latitude")
    private Double latitue;
    @SerializedName("Longitude")
    private Double longitue;
    @SerializedName("AtDateTime")
    private String date;

    public StatusNhanVien(String maNV, String tenNV, String divisionName, Double latitue, Double longitue, String date) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.divisionName = divisionName;
        this.latitue = latitue;
        this.longitue = longitue;
        this.date = date;
    }

    public StatusNhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Double getLatitue() {
        return latitue;
    }

    public void setLatitue(Double latitue) {
        this.latitue = latitue;
    }

    public Double getLongitue() {
        return longitue;
    }

    public void setLongitue(Double longitue) {
        this.longitue = longitue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
