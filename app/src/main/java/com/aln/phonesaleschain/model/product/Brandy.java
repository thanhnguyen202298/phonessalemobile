package com.aln.phonesaleschain.model.product;

import com.aln.phonesaleschain.customview.ItemVariable;

public class Brandy extends ItemVariable {
    public String BrandId;
    public String BrandName;
    public String Description;
    public String ImgUrl;

    @Override
    public String getIdDrawer() {
        return ImgUrl;
    }
}
