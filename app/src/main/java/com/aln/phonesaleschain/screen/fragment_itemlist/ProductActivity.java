package com.aln.phonesaleschain.screen.fragment_itemlist;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aln.phonesaleschain.BR;
import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.adapter.MyAdapter;
import com.aln.phonesaleschain.customview.ItemVariable;
import com.aln.phonesaleschain.databinding.ActivityProductBinding;
import com.aln.phonesaleschain.datahelper.preferenceapi.PreferenceUtils;
import com.aln.phonesaleschain.model.UserInfo;
import com.aln.phonesaleschain.model.order.OrderMaster;
import com.aln.phonesaleschain.utilities.Constants;
import com.aln.phonesaleschain.utilities.UtilBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductActivity.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProductActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductActivity extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;
    private ActivityProductBinding fragNews;
    OrderMaster master;

    private OnFragmentInteractionListener mListener;

    public ProductActivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param fragname Parameter 1.
     * @param orient   Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductActivity newInstance(String fragname, int orient) {
        ProductActivity fragment = new ProductActivity();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragNews = DataBindingUtil.inflate(inflater, R.layout.activity_product, container, false);
        initialize();
        return fragNews.getRoot();
    }

    private void initialize() {
        MyAdapter myAdapter = new MyAdapter(this.getContext(), R.layout.item_vertlarg2, 2, BR.item, mParam2);
        fragNews.mynews.setHasFixedSize(true);
        fragNews.mynews.setLayoutManager(myAdapter.getLayoutManager());
        fragNews.mynews.setAdapter(myAdapter);

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

    private void loadData() {
        List<ItemVariable> data = new ArrayList<>();
        if (mParam1.toLowerCase().equals("news")) {
            //loading news
        } else if (mParam1.toLowerCase().equals("cate")) {
            //loading cates
        } else if (mParam1.toLowerCase().equals("prod")) {
            //loading cates
        } else if (mParam1.toLowerCase().equals("notic")) {
            //loading cates
        } else if (mParam1.toLowerCase().equals("prom")) {
            //loading cates
        }
        fragNews.setNewsPaperlist(data);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

        loadData();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
