package com.aln.phonesaleschain.screen.fragment_itemlist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aln.phonesaleschain.BR;
import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.adapter.MyAdapter;
import com.aln.phonesaleschain.adapter.OnScrollCallBack;
import com.aln.phonesaleschain.customview.ContentVarible;
import com.aln.phonesaleschain.databinding.ActivityProductBinding;
import com.aln.phonesaleschain.datahelper.webapi.APIUtils;
import com.aln.phonesaleschain.datahelper.webapi.PathApi;
import com.aln.phonesaleschain.datahelper.webapi.ResultApi;
import com.aln.phonesaleschain.model.order.OrderMaster;
import com.aln.phonesaleschain.model.product.Brandy;
import com.aln.phonesaleschain.model.product.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductList extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;
    private OrderMaster master;
    PathApi aconect;
    OnProductListViewListener mListener;
    MyAdapter myAdapter;
    ContentVarible cl;
    ViewDataBinding fragNews;

    public static ProductList newInstance(String fragname, int orient) {
        ProductList fragment = new ProductList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, fragname);
        args.putInt(ARG_PARAM2, orient);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
        aconect = APIUtils.getService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragNews = DataBindingUtil.inflate(inflater, R.layout.chat_layout, container, false);
        return fragNews.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnProductListViewListener {
        // TODO: Update argument type and name
        void onProductListInteraction(Uri uri);
    }

}
