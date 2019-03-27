package com.aln.phonesaleschain.screen.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.screen.fragment_itemlist.ProductActivity;

public class ListItem extends AppCompatActivity {

    private FragmentManager frgManager;
    ProductActivity fragList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        frgManager = getSupportFragmentManager();
        fragList = ProductActivity.newInstance(getScreenName(), GridLayoutManager.VERTICAL);

        loadFragment();
    }

    private void loadFragment() {
        FragmentTransaction tf = frgManager.beginTransaction();
        tf.disallowAddToBackStack();
        tf.add(R.id.newsFrame, fragList);
        tf.commit();
    }

    private String getScreenName() {
        String it = getIntent().getStringExtra("Screen");
        return it == null ? "news" : it;
    }
}
