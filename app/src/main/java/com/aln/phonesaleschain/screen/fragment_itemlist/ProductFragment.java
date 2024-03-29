package com.aln.phonesaleschain.screen.fragment_itemlist;

import android.content.Context;
import android.databinding.DataBindingUtil;
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
import com.aln.phonesaleschain.listener.view_listener.OnclickFragment;
import com.aln.phonesaleschain.model.ChatIt;
import com.aln.phonesaleschain.model.order.OrderMaster;
import com.aln.phonesaleschain.model.product.Brandy;
import com.aln.phonesaleschain.model.product.Product;
import com.aln.phonesaleschain.model.product.Promotion;
import com.aln.phonesaleschain.model.speaknotice.Schadule;
import com.aln.phonesaleschain.model.speaknotice.SpeakInform;
import com.aln.phonesaleschain.utilities.UtilBasic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductFragment.OnProductInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment implements OnclickFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "name";//name
    private static final String ARG_PARAM2 = "orient";//orient
    private static final String ARG_PARAM3 = "object";//data
    private static final String ARG_PARAM4 = "column";//cokum

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;
    private String mParam3;
    private int mParam4;
    private ActivityProductBinding fragNews;
    private OrderMaster master;
    PathApi aconect;

    MyAdapter myAdapter;
    ContentVarible cl;
    private OnProductInteractionListener mListener;
    private Brandy Brandtofind;
    private Context context;

    public ProductFragment() {
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
    public static ProductFragment newInstance(String fragname, int orient) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, fragname);
        args.putInt(ARG_PARAM2, orient);
        fragment.setArguments(args);
        return fragment;
    }
    public static ProductFragment newInstance(String fragname, int orient, int colum) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, fragname);
        args.putInt(ARG_PARAM2, orient);
        args.putInt(ARG_PARAM4, colum);
        fragment.setArguments(args);
        return fragment;
    }

    public static ProductFragment newInstance(String fragname, int orient, String contentParent) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, fragname);
        args.putInt(ARG_PARAM2, orient);
        args.putString(ARG_PARAM3, contentParent);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2, GridLayoutManager.VERTICAL);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getInt(ARG_PARAM4,2);
            if (mParam3 != null)
                Brandtofind = UtilBasic.getGs().fromJson(mParam3, Brandy.class);
        }
        aconect = APIUtils.getService();
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
        cl = new ContentVarible();
        fragNews.setNewsPaperlist(cl);
        int res = R.layout.item_vertlarg2;
        if (mParam1.equals("chat")) {
            res = R.layout.chat_layout;
            fragNews.mynews.setBackgroundColor(getResources().getColor(R.color.navilight));
            fragNews.contentsend.setVisibility(View.VISIBLE);
            fragNews.send.setVisibility(View.VISIBLE);
        }
        myAdapter = new MyAdapter(context, res, mParam4, BR.item, mParam2, this);
        fragNews.mynews.setHasFixedSize(true);
        fragNews.mynews.setLayoutManager(myAdapter.getLayoutManager());
        fragNews.mynews.setAdapter(myAdapter);

        OnScrollCallBack rvSroll = new OnScrollCallBack(30, 1) {
            @Override
            public Boolean loadMore(int page, int totalItems, RecyclerView v) {
                loadData(page);
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
        loadData(1);
    }

    private void loadData(int page) {
//        List<ItemVariable> data = new ArrayList<>();
        if (Brandtofind != null) {
            loadProduct(page);
        } else if (mParam1.equals("news")) {
            //loading news
        } else if (mParam1.equals("branch")) {

        } else if (mParam1.equals("prod")) {
            myAdapter.setHasSub(true);
            LoadBrandy(page);
        } else if (mParam1.equals("notic")) {
            LoadInformNotice(page);
        } else if (mParam1.equals("prom")) {
            loadProm(page);
        } else if (mParam1.equals("scha")) {
            LoadSchadule(page);
        } else if (mParam1.equals("chat")) {
            loadChatMsg(page, "");
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String uri) {
        if (mListener != null) {
            mListener.onProductInteraction("", "".getClass());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProductInteractionListener) {
            mListener = (OnProductInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void LoadBrandy(int page) {
        aconect.getBrand(page, "all").enqueue(new Callback<ResultApi<List<Brandy>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<Brandy>>> call, Response<ResultApi<List<Brandy>>> response) {
                if (response.body() != null) {
                    ResultApi rss = response.body();
                    if (rss.status > 0 && rss.data != null) {
                        cl.setContent((List<Brandy>) rss.data);
                    }

                }
            }

            @Override
            public void onFailure(Call<ResultApi<List<Brandy>>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void LoadInformNotice(int page) {
        aconect.getSpeakInform("all", "", "", page).enqueue(new Callback<ResultApi<List<SpeakInform>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<SpeakInform>>> call, Response<ResultApi<List<SpeakInform>>> response) {
                if (response.body() != null) {
                    ResultApi rss = response.body();
                    if (rss.status > 0 && rss.data != null) {
                        cl.setContent((List<SpeakInform>) rss.data);
                    }

                }
            }

            @Override
            public void onFailure(Call<ResultApi<List<SpeakInform>>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void LoadSchadule(int page) {
        aconect.getSchadule(page, "all", "", "").enqueue(new Callback<ResultApi<List<Schadule>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<Schadule>>> call, Response<ResultApi<List<Schadule>>> response) {
                if (response.body() != null) {
                    ResultApi rss = response.body();
                    if (rss.status > 0 && rss.data != null) {
                        cl.setContent((List<Schadule>) rss.data);
                    }

                }
            }

            @Override
            public void onFailure(Call<ResultApi<List<Schadule>>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadProm(int page) {
        aconect.getPromotion(page, "all").enqueue(new Callback<ResultApi<List<Promotion>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<Promotion>>> call, Response<ResultApi<List<Promotion>>> response) {
                if (response.body() != null) {
                    ResultApi rss = response.body();
                    if (rss.status > 0 && rss.data != null) {
                        cl.setContent((List<Promotion>) rss.data);
                    }

                }
            }

            @Override
            public void onFailure(Call<ResultApi<List<Promotion>>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadProduct(int page) {
        aconect.getproductbybrand(page, Brandtofind.BrandId).enqueue(new Callback<ResultApi<List<Product>>>() {
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
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadChatMsg(int page, String fromdate) {
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        String s = simpleDateFormat.format(d);
        s=s.replace("/18/","/16/");
        aconect.getChatMsg("07d6003d-43a8-46a4-a382-3f9f2c1f93d9", s, page).enqueue(new Callback<ResultApi<List<ChatIt>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<ChatIt>>> call, Response<ResultApi<List<ChatIt>>> response) {
                if (response.body() != null) {
                    ResultApi rss = response.body();
                    if (rss.status > 0 && rss.data != null) {
                        cl.setContent((List<ChatIt>) rss.data);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResultApi<List<ChatIt>>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void OnClickBrandy(Object data) {
        mListener.onProductInteraction(UtilBasic.ObjectToJson(data), data.getClass());
    }

    public interface OnProductInteractionListener {
        // TODO: Update argument type and name
        void onProductInteraction(String data, Class type);
    }
}
