package com.aln.phonesaleschain.datahelper.webapi;

import com.aln.phonesaleschain.gps.CurrentPosition;
import com.aln.phonesaleschain.model.HistoryTrackingResponse;
import com.aln.phonesaleschain.model.ResponseLastPositionModel;
import com.aln.phonesaleschain.model.ResponseSavePosition;
import com.aln.phonesaleschain.model.order.OrderDetail;
import com.aln.phonesaleschain.model.order.OrderMaster;
import com.aln.phonesaleschain.model.product.Product;
import com.aln.phonesaleschain.screen.home.model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PathApi {
    @GET("/api/getproduct")
    Call<ResultApi<List<Product>>> getProduction(@Query("page") int page, @Query("allorid") String idall);

    @GET("/api/getorder")
    Call<ResultApi<List<OrderMaster>>> getOrder(@Query("page") int page, @Query("allorid") String idall);


    @GET("/api/getorderdtl")
    Call<ResultApi<List<OrderDetail>>> getOrderDtl(@Query("allorid") String idall);


    @GET("/api/getpromotion")
    Call<ResultApi<List<OrderDetail>>> getPromotion(@Query("allorid") String idall);


}
