package com.aln.phonesaleschain.screen.Presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.customview.ItemImageText;
import com.aln.phonesaleschain.datahelper.preferenceapi.PreferenceUtils;
import com.aln.phonesaleschain.utilities.Constants;

public class PresentActivity extends AppCompatActivity {

    private ItemImageText addressview, telview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.present_acty);

        init();
    }

    void init() {
        addressview = new ItemImageText(this, R.id.address, null);
        telview = new ItemImageText(this, R.id.tel, null);
        telview.setIdDrawerable(R.drawable.ic_call_navi_24dp);

        TextView la = findViewById(R.id.labelToolbar);
        la.setText(R.string.present_label);
        String s = getIntent().getStringExtra(Constants.KEY_CONTENT);
        TextView txt = findViewById(R.id.contenshow);
        txt.setText(s);

        s = PreferenceUtils.getContent(Constants.KEY_TEL);
        telview.setLabel(s);

        s = PreferenceUtils.getContent(Constants.KEY_COMADDRESS);
        addressview.setLabel(s);

    }
}