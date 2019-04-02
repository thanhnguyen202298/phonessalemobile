package com.aln.phonesaleschain.model.product;

import com.google.gson.annotations.SerializedName;

public class Promotion {
    public String PromotionCode;
    @SerializedName("Name")
    public String NamePro;
    public String ProductRange;
    public String Quantity;
    public String Discount;
    public String DiscountPercent;
    public String ProductMustBuy;
    public String ProductAllowBuy;
    public String ModifyBy;
    public String ModifyOn;
    public String CreateOn;
    public String FromDate;
    public String ToDate;
}
