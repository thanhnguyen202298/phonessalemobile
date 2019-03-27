package com.aln.phonesaleschain.customview;

import android.view.View;

import com.aln.phonesaleschain.adapter.MyAdapter;

public class ItemVariable {
    public int idDrawer;
    public int idString;
    public String label;


    public void ClickMe(View view){
        MyAdapter.onClick(idDrawer);
    }
}
