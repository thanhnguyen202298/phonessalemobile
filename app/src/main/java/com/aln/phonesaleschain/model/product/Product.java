package com.aln.phonesaleschain.model.product;

import android.graphics.Color;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.customview.ItemVariable;
import com.aln.phonesaleschain.utilities.UtilBasic;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public String getPrice() {
        return UtilBasic.getNumberFormat().format(Price)+ "đ";
    }

    @Override
    public String getIdDrawer() {
        if (ImageUrl == null) return null;
        if (!ImageUrl.contains(";"))
            return ImageUrl;
        return ImageUrl.substring(0, ImageUrl.indexOf(";"));
    }

    public List<String> getArrayDrawer() {

        List<String> stringsUrl = new ArrayList<>();
        if (ImageUrl == null) return stringsUrl;
        if (!ImageUrl.contains(";")) {
            stringsUrl.add(ImageUrl);
        } else {
            stringsUrl = Arrays.asList(ImageUrl.split(";"));
        }
        return stringsUrl;
    }

    @Override
    public String getLabel() {
        return ProductName;
    }

    @Override
    public String getIdItem() {
        return ProductCode;
    }

    public String getColor() {
        if (ColorPhone == null) return "#ffffff";
        if (!ColorPhone.contains(";"))
            return ColorPhone;
        return ColorPhone.substring(0, ColorPhone.indexOf(";"));
    }

    public List<String> getArrayColor() {
        List<String> stringsUrl = new ArrayList<>();
        if (ColorPhone == null) return stringsUrl;
        if (!ColorPhone.contains(";")) {
            stringsUrl.add(ColorPhone);
        } else {
            stringsUrl = Arrays.asList(ColorPhone.split(";"));
        }
        return stringsUrl;
    }

}
