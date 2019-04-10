package com.aln.phonesaleschain.screen.main;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.widget.TextView;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.screen.accountfrag.AccountFragment;
import com.aln.phonesaleschain.screen.fragment_itemlist.ProductActivity;
import com.aln.phonesaleschain.utilities.Constants;

public class ListItem extends AppCompatActivity implements ProductActivity.OnProductInteractionListener, AccountFragment.OnAccountInteractionListener {

    private FragmentManager frgManager;
    private Fragment fragList;
    private TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        label = findViewById(R.id.labelToolbar);
        frgManager = getSupportFragmentManager();
        String l = getScreenName();
        if (l.equals("acco"))
            fragList = new AccountFragment();
        else
            fragList = ProductActivity.newInstance(l, GridLayoutManager.VERTICAL);
        if (getIntent().getStringExtra(Constants.KEY_Label_Screen) != null)
            label.setText(getIntent().getStringExtra(Constants.KEY_Label_Screen));
        loadFragment();
    }

    private void loadFragment() {
        FragmentTransaction tf = frgManager.beginTransaction();
        tf.add(R.id.layoutlist, fragList);
        tf.commit();
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction tf = frgManager.beginTransaction();
        tf.replace(R.id.layoutlist, fragment);
        tf.commit();
    }

    private String getScreenName() {
        String it = getIntent().getStringExtra(Constants.KEY_SCREEN);
        return it == null ? "news" : it;
    }

    @Override
    public void onProductInteraction(String uri, String obj, Class type) {
        fragList = ProductActivity.newInstance(uri,GridLayoutManager.VERTICAL, obj);
        loadFragment(fragList);

    }

    @Override
    public void onAccountInteraction(Uri uri) {

    }
}
