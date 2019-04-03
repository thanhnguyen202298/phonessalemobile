package com.aln.phonesaleschain.model.product;

import android.graphics.Color;

import com.aln.phonesaleschain.customview.ItemVariable;
import com.google.gson.annotations.SerializedName;

public class Product extends ItemVariable {
    public String ProductCode;
    public String ProductName;
    public String ProductType;
    public String BrandId;
    @SerializedName("Color")
    public String ColorPhone;
    public String Detail;
    public String CreateOn;
    public String ImageUrl;
    public String ModifyBy;
    public String ModifyOn;
    public double Price;
    public String TypeName;

    @Override
    public String getIdDrawer() {
        return ImageUrl;
    }

    @Override
    public String getLabel() {
        return ProductName;
    }

    @Override
    public String getIdItem() {
        return ProductCode;
    }
}
