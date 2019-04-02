package com.aln.phonesaleschain.customview;

import android.view.View;

import com.aln.phonesaleschain.adapter.MyAdapter;
import com.google.gson.annotations.SerializedName;

public class ItemVariable {
    public String idDrawer;
    public String Label;

    public String Amount = "";

    public String getLabel() {
        if(Amount==null)
            return Label;
        return Label + "\n" + Amount;
    }

    public String getIdDrawer() {
        return idDrawer;
    }
}
