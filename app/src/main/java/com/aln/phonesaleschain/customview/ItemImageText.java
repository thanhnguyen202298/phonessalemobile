package com.aln.phonesaleschain.customview;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/*
* for using one layout in a View, but no list
* it wil find by parent id and set content to all text, Image
*
* by Thành Nguyễn Trung @mail: victo202298@gmail.com
* */
public class ItemImageText<I extends ImageView, P extends ViewGroup> {
    P selfView;
    private TextView txt;
    private I img;
    private int idDrawerable;

    public ItemImageText(Activity parent, int ResId, View.OnClickListener m_listen) {
        selfView = parent.findViewById(ResId);
        selfView.setOnClickListener(m_listen);
        setupChildView(selfView);
        if (img == null)
            throw new IllegalArgumentException("Failed in layout");
    }

    public ItemImageText(View parent, int ResId, View.OnClickListener m_listen) {
        selfView = parent.findViewById(ResId);
        selfView.setOnClickListener(m_listen);
        setupChildView(selfView);
        if (img == null)
            throw new IllegalArgumentException("Failed in layout");
    }

    public ItemImageText(Dialog parent, int ResId, View.OnClickListener m_listen) {
        selfView = parent.findViewById(ResId);
        selfView.setOnClickListener(m_listen);
        setupChildView(selfView);
        if (img == null)
            throw new IllegalArgumentException("Failed in layout");
    }


    void setupChildView(P ln) {
        for (int i = 0; i < ln.getChildCount(); i++) {
            if (ln.getChildAt(i) instanceof TextView)
                txt = (TextView) ln.getChildAt(i);
            else if (ln.getChildAt(i) instanceof ImageView)
                img = (I) ln.getChildAt(i);
            else if (ln.getChildAt(i) instanceof ViewGroup) {
                P vg = (P) ln.getChildAt(i);
                setupChildView(vg);
            }
        }
    }

    public String getLabel() {
        if (txt == null) return null;
        return txt.getText().toString();
    }

    public void setLabel(String label) {
        if (txt == null) return;
        txt.setText(label);
    }

    public void setLabel(int reslabel) {
        if (txt == null) return;
        txt.setText(selfView.getContext().getText(reslabel));
    }

    public int getIdDrawerable() {
        return img.getId();
    }

    public void setIdDrawerable(int idDrawerable) {
        this.idDrawerable = idDrawerable;
        setupImage(idDrawerable);
    }


    private void setupImage(int resImg) {
        img.setImageResource(resImg);
    }
}
