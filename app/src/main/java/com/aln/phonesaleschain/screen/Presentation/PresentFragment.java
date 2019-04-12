package com.aln.phonesaleschain.screen.Presentation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.adapter.MyAdapter;
import com.aln.phonesaleschain.customview.ContentVarible;
import com.aln.phonesaleschain.customview.ItemImageText;
import com.aln.phonesaleschain.databinding.ActivityProductBinding;
import com.aln.phonesaleschain.datahelper.preferenceapi.PreferenceUtils;
import com.aln.phonesaleschain.datahelper.webapi.PathApi;
import com.aln.phonesaleschain.model.CommonModel;
import com.aln.phonesaleschain.model.order.OrderMaster;
import com.aln.phonesaleschain.model.product.Brandy;
import com.aln.phonesaleschain.screen.fragment_itemlist.ProductFragment;
import com.aln.phonesaleschain.utilities.Constants;
import com.aln.phonesaleschain.utilities.UtilBasic;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PresentFragment} interface
 * to handle interaction events.
 * Use the {@link PresentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PresentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "object";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ItemImageText addressview, telview;
    CommonModel data;
    private OnPresentInteractionListener mListener;
    private Context context;

    public PresentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param fragmane Parameter 1.
     * @param object   Parameter 2.
     * @return A new instance of fragment PresentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PresentFragment newInstance(String fragmane, String object) {
        PresentFragment fragment = new PresentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, fragmane);
        args.putString(ARG_PARAM2, object);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            if (mParam2 != null)
                data = UtilBasic.getGs().fromJson(mParam2, CommonModel.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_present, container, false);
        init(v);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPresentInteractionListener) {
            mListener = (OnPresentInteractionListener) context;
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

    void init(View v) {
        addressview = new ItemImageText(v, R.id.address, null);
        telview = new ItemImageText(v, R.id.tel, null);
        telview.setIdDrawerable(R.drawable.ic_call_navi_24dp);

        TextView txt = v.findViewById(R.id.contenshow);
        txt.setText(data.content);
        telview.setLabel(data.title);
        addressview.setLabel(data.text);

    }

    public interface OnPresentInteractionListener {
        // TODO: Update argument type and name
        void onPresentInteraction(Uri uri);
    }
}
