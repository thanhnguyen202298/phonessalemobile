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
import com.aln.phonesaleschain.model.CommonModel;
import com.aln.phonesaleschain.model.product.Brandy;
import com.aln.phonesaleschain.model.product.Product;
import com.aln.phonesaleschain.screen.Presentation.PresentFragment;
import com.aln.phonesaleschain.screen.accountfrag.AccountFragment;
import com.aln.phonesaleschain.screen.fragment_itemlist.ItemDetail;
import com.aln.phonesaleschain.screen.fragment_itemlist.ProductFragment;
import com.aln.phonesaleschain.utilities.Constants;
import com.aln.phonesaleschain.utilities.UtilBasic;

public class ListItem extends AppCompatActivity implements ProductFragment.OnProductInteractionListener, AccountFragment.OnAccountInteractionListener, ItemDetail.OnItemInteractionListener , PresentFragment.OnPresentInteractionListener {

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
        else if(l.equals("present"))
            fragList = PresentFragment.newInstance(l, null);
        else if(l.equals("chat"))
            fragList = ProductFragment.newInstance(l,GridLayoutManager.VERTICAL);
        else
            fragList = ProductFragment.newInstance(l, GridLayoutManager.VERTICAL);

        if(l.equals("chat"))
            label.setText(getString(R.string.compani_present));
        else if (getIntent().getStringExtra(Constants.KEY_Label_Screen) != null)
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
        tf.addToBackStack(fragment.getArguments().getString(ProductFragment.ARG_PARAM1));
        tf.commit();
    }

    private String getScreenName() {
        String it = getIntent().getStringExtra(Constants.KEY_SCREEN);
        return it == null ? "news" : it;
    }

    @Override
    public void onProductInteraction(String obj, Class type) {
        if (type.equals(Brandy.class))
            fragList = ProductFragment.newInstance("product", GridLayoutManager.VERTICAL, obj);
        else if(type.equals(Product.class))
            fragList = ItemDetail.newInstance("productid", GridLayoutManager.HORIZONTAL, obj);
        else if(type.equals(CommonModel.class)){
            CommonModel m = UtilBasic.getGs().fromJson(obj,CommonModel.class);
            label.setText(m.mLabel);
            fragList = PresentFragment.newInstance("productid", obj);
        }

        loadFragment(fragList);
    }

    @Override
    public void onAccountInteraction(Uri uri) {

    }

    @Override
    public void onItemInteraction(Uri uri) {

    }

    @Override
    public void onPresentInteraction(Uri uri) {

    }
}
