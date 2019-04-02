package com.aln.phonesaleschain.model.order;

import com.google.gson.annotations.SerializedName;

public class OrderDetail {

    public String OrderCode;
    public String ProductCode;
    public String Quantity;
    public String Price;
    public String Amount;
    public String DiscountPercent;
    public String Discount;

    @SerializedName("Color")
    public String ColorPhone;
    public String ProductName;

    public OrderDetail() {
    }
}
