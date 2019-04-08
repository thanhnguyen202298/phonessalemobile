package com.aln.phonesaleschain.screen.fragment_itemlist;

import android.content.Context;
import android.databinding.DataBindingUtil;
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
    ActivityProductBinding fragNews;

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
        fragNews = DataBindingUtil.inflate(inflater, R.layout.activity_product, container, false);
        initialize();
        loadProduct(1);
        return fragNews.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProductListViewListener) {
            mListener = (OnProductListViewListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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

    private void initialize() {
        cl = new ContentVarible();
        fragNews.setNewsPaperlist(cl);
        myAdapter = new MyAdapter(this.getContext(), R.layout.item_vertlarg2, 2, BR.item, mParam2);
        fragNews.mynews.setHasFixedSize(true);
        fragNews.mynews.setLayoutManager(myAdapter.getLayoutManager());
        fragNews.mynews.setAdapter(myAdapter);

        OnScrollCallBack rvSroll = new OnScrollCallBack(30,1) {
            @Override
            public Boolean loadMore(int page, int totalItems, RecyclerView v) {
                loadProduct(page);
                return null;
            }
        };
        rvSroll.setLayout(myAdapter.getLayoutManager());
        fragNews.mynews.setOnScrollListener(rvSroll);

        fragNews.fabCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!master.detailslist.isEmpty()) {

                    } else {
                        Toast.makeText(getContext(), "Chưa có sản phẩm", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage() + "debug", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadProduct(int page){
        aconect.getProduction(page,"all").enqueue(new Callback<ResultApi<List<Product>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<Product>>> call, Response<ResultApi<List<Product>>> response) {
                if (response.body() != null) {
                    ResultApi rss = response.body();
                    if (rss.status > 0 && rss.data != null) {
                        cl.setContent((List<Product>) rss.data);
                    }

                }
            }

            @Override
            public void onFailure(Call<ResultApi<List<Product>>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
