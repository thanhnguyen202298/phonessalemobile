package com.aln.phonesaleschain.adapter;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MyBindUtile {
    @BindingAdapter("android:data")
    public static void setListDataRV(RecyclerView v, Object newitems) {
        if (v.getAdapter() instanceof MyBindingAdapter) {
            ((MyBindingAdapter)v.getAdapter()).setData(newitems);
        }
    }

    @BindingAdapter("android:image")
    public static void setImgData(ImageView v, String url) {
        Picasso.get().load(url).into(v);
    }
}