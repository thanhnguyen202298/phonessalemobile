package com.aln.phonesaleschain.datahelper.webapi;

import com.aln.phonesaleschain.gps.CurrentPosition;
import com.aln.phonesaleschain.model.HistoryTrackingResponse;
import com.aln.phonesaleschain.model.ResponseLastPositionModel;
import com.aln.phonesaleschain.model.ResponseSavePosition;
import com.aln.phonesaleschain.screen.home.model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PathApi {
    @GET("/api/getmovings")
    Call<List<CurrentPosition>> getPositionEmployee(@Query("page") int page);

    @GET("/api/getListEmpMoving")
    Call<ResponseLastPositionModel> getLastStatus(@Query("itime") int itime, @Query("empCode") String empcode);

    @GET("/api/getmovings")
    Call<HistoryTrackingResponse> getHistoryTracking(@Query("page") int page, @Query("Empcode") String empCode, @Query("pagesize") int pageSize);

    @POST("/api/login")
    @FormUrlEncoded
    Call<ResultApi<List<UserInfo>>> getStatusLogin(@Field("UserName") String username, @Field("Password") String password);

    @POST("/api/saveloc")
    @FormUrlEncoded
    Call<ResponseSavePosition> savePosition(@Field("EmpCode") String empCode, @Field("Latitude") Double lat, @Field("Longitude") Double lon, @Field("Address") String address);
}
