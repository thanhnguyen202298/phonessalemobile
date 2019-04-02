package com.aln.phonesaleschain.model.product;

import android.graphics.Color;

import com.google.gson.annotations.SerializedName;

public class Product {
    public String ProductCode;
    public String ProductName;
    public String ProductType;
    public String BrandId;
    @SerializedName("Color")
    public String ColorPhone;
    public String Detail;
    public String CreateOn;
    public String Image;
    public String ModifyBy;
    public String ModifyOn;
    public double Price;
    public String TypeName;
}
