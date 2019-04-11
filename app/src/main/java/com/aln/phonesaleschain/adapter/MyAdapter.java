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

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.listener.OnImageCLick;
import com.aln.phonesaleschain.listener.view_listener.OnclickFragment;
import com.aln.phonesaleschain.model.product.Brandy;
import com.aln.phonesaleschain.model.product.CommonModel;
import com.aln.phonesaleschain.model.product.Product;
import com.aln.phonesaleschain.model.product.Promotion;
import com.aln.phonesaleschain.model.speaknotice.Schadule;
import com.aln.phonesaleschain.model.speaknotice.SpeakInform;
import com.aln.phonesaleschain.screen.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemHolder> implements MyBindingAdapter<List<Object>> {

    private List mylist;
    private static Context base;
    private GridLayoutManager managerlayout;
    private int resLayout;
    private int idVar;

    private OnclickFragment clickListener;
    private OnImageCLick imgListener;
    private int selected = -1;
    private boolean hasSub;

    public void setHasSub(boolean hasSub) {
        this.hasSub = hasSub;
    }

    public MyAdapter(Context context, int resIdlayout, int column, int varBinding, int orient, OnclickFragment mclickListener) {
        mylist = new ArrayList<>();
        base = context;
        clickListener = mclickListener;
        resLayout = resIdlayout;
        managerlayout = new GridLayoutManager(context, column, orient, false);
        idVar = varBinding;
    }

    public void setImgListener(OnImageCLick listenerproduct) {
        imgListener = listenerproduct;
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
    public void onBindViewHolder(@NonNull final ItemHolder itemHolder, int i) {
        Object oj = mylist.get(i);
        ItemBindingType(itemHolder, oj, i);

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

    void ItemBindingType(final ItemHolder itemHolder, Object oj, final int i) {
        if (oj instanceof Brandy) {
            final Brandy br = (Brandy) oj;

            itemHolder.getLayoutBind().setVariable(idVar, br);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.OnClickBrandy(br);
                }
            });

        } else if (oj instanceof Product) {
            final Product pr = (Product) oj;
            itemHolder.getLayoutBind().setVariable(idVar, pr);

            itemHolder.getLayoutBind().setVariable(idVar, pr);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.OnClickBrandy(pr);
                }
            });

        } else if (oj instanceof Promotion) {
            final Promotion prom = (Promotion) oj;
            itemHolder.getLayoutBind().setVariable(idVar, prom);

            itemHolder.getLayoutBind().setVariable(idVar, prom);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.OnClickBrandy(prom);
                }
            });

        } else if (oj instanceof SpeakInform) {
            final SpeakInform spk = (SpeakInform) oj;
            itemHolder.getLayoutBind().setVariable(idVar, spk);

            itemHolder.getLayoutBind().setVariable(idVar, spk);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.OnClickBrandy(spk);
                }
            });

        } else if (oj instanceof Schadule) {
            final Schadule scd = (Schadule) oj;
            itemHolder.getLayoutBind().setVariable(idVar, scd);

            itemHolder.getLayoutBind().setVariable(idVar, scd);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.OnClickBrandy(scd);
                }
            });

        } else if (oj instanceof CommonModel) {
            final CommonModel cd = (CommonModel) oj;
            itemHolder.getLayoutBind().setVariable(idVar, cd);
            cd.select = i == selected;

            setViewItem(itemHolder.itemView, cd.select);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selected = i;
                    imgListener.onClickImage(cd.text);
                    notifyDataSetChanged();
                }
            });
        }
    }

    void setViewItem(View v, boolean choose) {
        if (choose) {
            v.setPadding(2, 2, 2, 2);
            v.setBackgroundResource(R.color.colorAccent);
        } else {
            v.setPadding(0, 0, 0, 0);
            v.setBackgroundResource(R.color.transparent);
        }
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