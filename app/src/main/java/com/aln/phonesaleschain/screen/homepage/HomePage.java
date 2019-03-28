package com.aln.phonesaleschain.screen.homepage;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.screen.fragment_itemlist.ProductActivity;

public class HomePage extends AppCompatActivity implements ProductActivity.OnProductInteractionListener {
    private ProductActivity newsFrag, cateFrag;
    private FragmentManager frgManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_acty);
        init();
    }

    private void init() {
        frgManager = getSupportFragmentManager();
        newsFrag = ProductActivity.newInstance("news", GridLayoutManager.HORIZONTAL);
        cateFrag = ProductActivity.newInstance("cates", GridLayoutManager.HORIZONTAL);
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
    public void onProductInteraction(Uri uri) {

    }
}
