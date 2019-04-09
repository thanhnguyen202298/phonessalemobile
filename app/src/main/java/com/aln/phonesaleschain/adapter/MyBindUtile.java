package com.aln.phonesaleschain.adapter;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.datahelper.webapi.APIUtils;
import com.aln.phonesaleschain.datahelper.webapi.PathApi;
import com.squareup.picasso.Picasso;

public class MyBindUtile {
    @BindingAdapter("android:data")
    public static void setListDataRV(RecyclerView v, Object newitems) {
        if (v.getAdapter() instanceof MyBindingAdapter) {
            ((MyBindingAdapter) v.getAdapter()).setData(newitems);
        }
    }

    @BindingAdapter("android:image")
    public static void setImgData(ImageView v, String url) {
        if (url != null)
            if (!url.contains("http://"))
                url = APIUtils.BASE_PRIVATE + url;
        Picasso.get().load(url).placeholder(R.drawable.ic_satellite_black_24dp).into(v);
    }

    @BindingAdapter("android:alnid")
    public static void setIdView(View v, String id) {

    }
}