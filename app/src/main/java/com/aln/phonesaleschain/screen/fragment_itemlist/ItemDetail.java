package com.aln.phonesaleschain.screen.fragment_itemlist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aln.phonesaleschain.BR;
import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.adapter.MyAdapter;
import com.aln.phonesaleschain.databinding.ItemDetailBinding;
import com.aln.phonesaleschain.listener.OnImageCLick;
import com.aln.phonesaleschain.model.product.Product;
import com.aln.phonesaleschain.utilities.UtilBasic;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ItemDetail.OnItemInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ItemDetail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemDetail extends Fragment implements OnImageCLick {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "object";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;
    private String mParam3;
    private Context ctx;
    private OnItemInteractionListener mListener;

    ItemDetailBinding itemBinding;
    MyAdapter myAdapter;
    Product cl;

    public ItemDetail() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param fragname Parameter 1.
     * @param orient   Parameter 2.
     * @return A new instance of fragment ItemDetail.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemDetail newInstance(String fragname, int orient, String obj) {
        ItemDetail fragment = new ItemDetail();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, fragname);
        args.putInt(ARG_PARAM2, orient);
        args.putString(ARG_PARAM3, obj);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            cl = UtilBasic.getGs().fromJson(mParam3, Product.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        itemBinding = DataBindingUtil.inflate(inflater, R.layout.item_detail, container, false);
        initial();
        return itemBinding.getRoot();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onClickBtn(View view) {

    }

    void initial() {
        itemBinding.setItemdetail(cl);
        myAdapter = new MyAdapter(ctx, R.layout.item_min_img, 1, BR.itemUrl, mParam2, null);
        itemBinding.listimg.setHasFixedSize(true);
        itemBinding.listimg.setLayoutManager(myAdapter.getLayoutManager());
        itemBinding.listimg.setAdapter(myAdapter);
        myAdapter.setImgListener(this);

        MyAdapter colorarrayada = new MyAdapter(ctx, R.layout.item_min_img, 1, BR.itemUrl, mParam2, null);
        itemBinding.listcolor.setHasFixedSize(true);
        itemBinding.listcolor.setLayoutManager(colorarrayada.getLayoutManager());
        itemBinding.listcolor.setAdapter(colorarrayada);
        colorarrayada.setImgListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemInteractionListener) {
            mListener = (OnItemInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        ctx = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClickImage(String uri) {
        if (uri.length() < 10) {
            cl.setSelectedColor(uri);
        } else cl.setSelectedImg(uri);
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

    public interface OnItemInteractionListener {
        // TODO: Update argument type and name
        void onItemInteraction(Uri uri);
    }
}