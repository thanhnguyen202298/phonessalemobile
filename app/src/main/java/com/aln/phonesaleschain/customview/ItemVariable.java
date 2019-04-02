package com.aln.phonesaleschain.customview;

import android.view.View;

import com.aln.phonesaleschain.adapter.MyAdapter;
import com.google.gson.annotations.SerializedName;

public class ItemVariable {
    public int idDrawer;
    public int idString;

    @SerializedName("name")
    public String label;

    public String amount = "";

    public String getLabel() {
        return label + "\n" + amount;
    }

}
