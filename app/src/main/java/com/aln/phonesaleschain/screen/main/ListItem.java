package com.aln.phonesaleschain.screen.main;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.screen.accountfrag.AccountFragment;
import com.aln.phonesaleschain.screen.fragment_itemlist.ProductActivity;
import com.aln.phonesaleschain.utilities.Constants;

public class ListItem extends AppCompatActivity implements ProductActivity.OnProductInteractionListener, AccountFragment.OnAccountInteractionListener {

    private FragmentManager frgManager;
    private Fragment fragList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        frgManager = getSupportFragmentManager();
        if(getScreenName().equals("acco"))
            fragList = new AccountFragment();
        else
        fragList = ProductActivity.newInstance(getScreenName(), GridLayoutManager.VERTICAL);

        loadFragment();
    }

    private void loadFragment() {
        FragmentTransaction tf = frgManager.beginTransaction();
        tf.disallowAddToBackStack();
        tf.add(R.id.layoutlist, fragList);
        tf.commit();
    }

    private String getScreenName() {
        String it = getIntent().getStringExtra(Constants.KEY_SCREEN);
        return it == null ? "news" : it;
    }

    @Override
    public void onProductInteraction(Uri uri) {

    }

    @Override
    public void onAccountInteraction(Uri uri) {

    }
}
