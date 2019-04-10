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
import com.aln.phonesaleschain.model.product.Brandy;
import com.aln.phonesaleschain.model.product.Product;
import com.aln.phonesaleschain.screen.accountfrag.AccountFragment;
import com.aln.phonesaleschain.screen.fragment_itemlist.ItemDetail;
import com.aln.phonesaleschain.screen.fragment_itemlist.ProductActivity;
import com.aln.phonesaleschain.utilities.Constants;

public class ListItem extends AppCompatActivity implements ProductActivity.OnProductInteractionListener, AccountFragment.OnAccountInteractionListener, ItemDetail.OnItemInteractionListener {

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
        tf.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        tf.add(R.id.layoutlist, fragList);
        tf.commit();
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction tf = frgManager.beginTransaction();
        tf.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,R.anim.slide_in_left,R.anim.trans_right_out);
        tf.replace(R.id.layoutlist, fragment);
        tf.addToBackStack(fragment.getArguments().getString(ProductActivity.ARG_PARAM1));
        tf.commit();
    }

    private String getScreenName() {
        String it = getIntent().getStringExtra(Constants.KEY_SCREEN);
        return it == null ? "news" : it;
    }

    @Override
    public void onProductInteraction(String uri, String obj, Class type) {
        if (type.equals(Brandy.class))
            fragList = ProductActivity.newInstance(uri, GridLayoutManager.VERTICAL, obj);
        else if(type.equals(Product.class))
            fragList = ItemDetail.newInstance(uri, GridLayoutManager.HORIZONTAL, obj);
        loadFragment(fragList);

    }

    @Override
    public void onAccountInteraction(Uri uri) {

    }

    @Override
    public void onItemInteraction(Uri uri) {

    }
}
