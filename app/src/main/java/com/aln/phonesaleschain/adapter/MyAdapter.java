package com.aln.phonesaleschain.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.customview.ItemVariable;
import com.aln.phonesaleschain.screen.home.HomeActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemHolder> implements MyBindingAdapter<List<Object>> {

    private List<Object> mylist;
    private static Context base;
    private GridLayoutManager managerlayout;
    private int resLayout;
    private int idVar;

    public MyAdapter(Context context, int resIdlayout, int column, int varBinding, int orient) {
        mylist = new ArrayList<>();
        base = context;
        resLayout = resIdlayout;
        managerlayout = new GridLayoutManager(context, column, orient, false);
        idVar = varBinding;
    }

    public GridLayoutManager getLayoutManager() {
        return managerlayout;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater lif = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding vdata = DataBindingUtil.inflate(lif, resLayout, viewGroup, false);
        return new ItemHolder(vdata);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        itemHolder.getLayoutBind().setVariable(idVar,mylist.get(i));

        itemHolder.v.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }


    public static void onClick(int ID) {
        Intent toScreen = new Intent();
        toScreen.putExtra("k", -1);
        switch (ID) {
            case R.drawable.ic_006_home_insurance:
                toScreen = new Intent(base, HomeActivity.class);
                break;
            case R.drawable.ic_022_gift_box:
                break;
            case R.drawable.ic_home:
                break;
            case R.drawable.ic_alarm_clock:
                break;
        }

        if (toScreen.getIntExtra("k", -2) == -2)
            base.startActivity(toScreen);
    }

    @Override
    public void setData(List<Object> data) {
        mylist = data;
        notifyDataSetChanged();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        ViewDataBinding v;

        public ItemHolder(ViewDataBinding view) {
            super(view.getRoot());
            v = view;
        }

        public ViewDataBinding getLayoutBind() {
            return v;
        }
    }
}