package com.aln.phonesaleschain.model.product;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.aln.phonesaleschain.BR;
import com.aln.phonesaleschain.customview.MyVariable;
import com.aln.phonesaleschain.model.CommonModel;
import com.aln.phonesaleschain.utilities.UtilBasic;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Product extends BaseObservable implements MyVariable {
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
        return UtilBasic.getNumberFormat().format(Price) + " đ";
    }

    @Bindable
    private String selectedImg;

    public String getSelectedImg() {
        if (selectedImg == null)
            return getIdDrawer();
        return selectedImg;
    }

    public void setSelectedImg(String selectedImg) {
        this.selectedImg = selectedImg;
        notifyPropertyChanged(BR.selectedImg);
    }

    @Bindable
    private String selectedColor;

    public String getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(String selectedColr) {
        this.selectedColor = selectedColr;
    }


    @Override
    public String getIdDrawer() {
        if (ImageUrl == null) return null;
        if (!ImageUrl.contains(";"))
            return ImageUrl;
        return ImageUrl.substring(0, ImageUrl.indexOf(";"));
    }

    public List<CommonModel> getArrayDrawer() {

        List<CommonModel> stringsUrl = new ArrayList<>();
        if (ImageUrl == null) return stringsUrl;
        if (!ImageUrl.contains(";")) {
            stringsUrl.add(new CommonModel(ImageUrl));
        } else {
            String[] arr = ImageUrl.split(";");
            for (String s : arr) {
                final CommonModel model = new CommonModel(s);
                stringsUrl.add(model);
            }
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

    public List<CommonModel> getArrayColor() {
        List<CommonModel> stringsUrl = new ArrayList<>();
        if (ColorPhone == null) return stringsUrl;
        if (!ColorPhone.contains(";")) {
            stringsUrl.add(new CommonModel(ColorPhone));
        } else {
            String[] arr = ColorPhone.split(";");
            for (String s : arr) {
                final CommonModel model = new CommonModel(s);
                stringsUrl.add(model);
            }
        }
        return stringsUrl;
    }

}
