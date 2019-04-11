package com.aln.phonesaleschain.screen.homepage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.widget.TextView;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.screen.fragment_itemlist.ProductFragment;

public class HomePage extends AppCompatActivity implements ProductFragment.OnProductInteractionListener {
    private ProductFragment newsFrag, cateFrag;
    private FragmentManager frgManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_acty);
        init();
    }

    private void init() {
        TextView label = findViewById(R.id.labelToolbar);
        label.setText(R.string.home_Label);
        frgManager = getSupportFragmentManager();
        newsFrag = ProductFragment.newInstance("news", GridLayoutManager.HORIZONTAL);
        cateFrag = ProductFragment.newInstance("prod", GridLayoutManager.HORIZONTAL);
        loadFragment();
    }

    private void loadFragment() {
        FragmentTransaction tf = frgManager.beginTransaction();
        tf.disallowAddToBackStack();
        tf.add(R.id.newsFrame, newsFrag);
        tf.add(R.id.CategoFrame, cateFrag);
        tf.commit();
    }

    @Override
    public void onProductInteraction(String uri, String data, Class type) {

    }
}
