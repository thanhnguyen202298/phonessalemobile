package com.aln.phonesaleschain.utilities;

import android.content.Context;

import com.google.gson.Gson;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class UtilBasic {
    private static SimpleDateFormat sdf;
    private static NumberFormat numberFormat;
    private static Gson gs;

    public static SimpleDateFormat getSdf() {
        if (sdf == null) sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm a");
        return sdf;
    }

    public static SimpleDateFormat get_yyyyMMddHHmmss() {
        if (sdf == null) sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf;
    }

    public static String Date4Server(String ddmm) {
        if (ddmm == null) return "";
        String tm = ddmm.substring(3, 6);
        tm += ddmm.substring(0, 3);
        tm += ddmm.substring(6);
        return tm;
    }

    public static NumberFormat getNumberFormat() {
        if (numberFormat == null) numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
        return numberFormat;
    }

    public static String ObjectToJson(Object obj) {
        if (gs == null) gs = new Gson();
        return gs.toJson(obj);
    }

    public static Gson getGs() {
        if (gs == null) gs = new Gson();
        return gs;
    }
}
