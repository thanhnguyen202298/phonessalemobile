package com.aln.phonesaleschain.datahelper.webapi;

import com.aln.phonesaleschain.gps.CurrentPosition;
import com.aln.phonesaleschain.model.ChatIt;
import com.aln.phonesaleschain.model.HistoryTrackingResponse;
import com.aln.phonesaleschain.model.ResponseLastPositionModel;
import com.aln.phonesaleschain.model.ResponseSavePosition;
import com.aln.phonesaleschain.model.order.OrderDetail;
import com.aln.phonesaleschain.model.order.OrderMaster;
import com.aln.phonesaleschain.model.product.Brandy;
import com.aln.phonesaleschain.model.product.Product;
import com.aln.phonesaleschain.model.product.Promotion;
import com.aln.phonesaleschain.model.speaknotice.Schadule;
import com.aln.phonesaleschain.model.speaknotice.SpeakInform;
import com.aln.phonesaleschain.screen.home.model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PathApi {

    //<editor-fold desc="retrieve data">

    @GET("/api/getproduct")
    Call<ResultApi<List<Product>>> getProduction(@Query("page") int page, @Query("allorid") String idall);

    @GET("/api/getproductbybrand")
    Call<ResultApi<List<Product>>> getproductbybrand(@Query("page") int page, @Query("allorid") String idall);

    @GET("/api/getorder")
    Call<ResultApi<List<OrderMaster>>> getOrder(@Query("page") int page, @Query("allorid") String idall);


    @GET("/api/getorderdtl")
    Call<ResultApi<List<OrderDetail>>> getOrderDtl(@Query("allorid") String idall);


    @GET("/api/getpromotion")
    Call<ResultApi<List<Promotion>>> getPromotion(@Query("page") int page, @Query("allorid") String idall);


    @GET("/api/getpromotionbydate")
    Call<ResultApi<List<Promotion>>> getPromotionByDate(@Query("fromdate") String fromdate, @Query("todate") String todate);

    @GET("/api/getbrand")
    Call<ResultApi<List<Brandy>>> getBrand(@Query("page") int page, @Query("allorid") String idall);

    @POST("/api/login")
    Call<ResultApi<List<UserInfo>>> getStatusLogin(@Body UserInfo user);

    //4/4/2019

    @GET("/api/getSpeakInform")
    Call<ResultApi<List<SpeakInform>>> getSpeakInform(@Query("allorid") String idall, @Query("fromdate") String fromdate, @Query("todate") String todate, @Query("page") int page);

    @GET("/api/getChatMsg")
    Call<ResultApi<List<ChatIt>>> getChatMsg(@Query("allorid") String idall, @Query("fromdate") String fromdate, @Query("page") int page);

    @GET("/api/getSchadule")
    Call<ResultApi<List<Schadule>>> getSchadule(@Query("page") int page, @Query("allorid") String idall, @Query("fromdate") String fromdate, @Query("todate") String todate);

    //</editor-fold>

    //<editor-fold desc="insert & update data">

    @POST("saveProduct")
    Call<ResultApi> saveProduct(@Body Product product);


    @POST("savePromotion")
    Call<ResultApi> savePromotion(@Body Promotion product);

    @POST("saveSchadule")
    Call<ResultApi> saveSchadule(@Body Promotion product);

    @POST("saveOrder")
    Call<ResultApi> saveOrder(@Body Product product);

    @POST("saveNotice")
    Call<ResultApi> saveNotice(@Body Product product);

    @POST("saveChat")
    Call<ResultApi> saveChat(@Body Product product);


    @POST("saveBrand")
    Call<ResultApi> saveBrand(@Body Product product);


    @POST("saveuser")
    Call<ResultApi> saveuser(@Body Product product);



    //</editor-fold>
}