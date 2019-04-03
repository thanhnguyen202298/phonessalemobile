package com.aln.phonesaleschain.datahelper.webapi;

public class APIUtils {

//    public static final String BASE_PRIVATE = "http://125.253.113.123:10002";
//    public static final String BASE_PRIVATE = "http://112.78.1.203";
    public static final String BASE_PRIVATE = "http://192.168.1.119:8181";




    public static PathApi getService() {
        return RetrofitClient.getClient(BASE_PRIVATE).create(PathApi.class);
    }

    public static PathApi getSOService () {
        return RetrofitClient.getClient(BASE_PRIVATE).create(PathApi.class);
    }

    public static PathApi getServicePrivate () {
        return RetrofitClient.getClient(BASE_PRIVATE).create(PathApi.class);
    }

}