package com.aln.phonesaleschain.datahelper.preferenceapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.aln.phonesaleschain.utilities.Constants;
import com.google.android.gms.common.util.SharedPreferencesUtils;

public class PreferenceUtils {
    public PreferenceUtils() {

    }

    public static SharedPreferences prefs;

    public static SharedPreferences getSharesPrefer(Context context) {
        if (prefs == null)
            prefs = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return prefs;
    }

    public static boolean savePassword(String password) {
        saveContent(Constants.KEY_PASSWORD, password);
        return true;
    }

    public static String getPassword() {
        return getContent(Constants.KEY_PASSWORD);
    }

    public static boolean saveUserName(String username) {
        saveContent(Constants.KEY_TEN, username);
        return true;
    }

    public static String getUserName() {
        return getContent(Constants.KEY_TEN);
    }

    public static boolean saveEmployeeCode(String employeeCode) {
        saveContent(Constants.KEY_MA, employeeCode);
        return true;
    }

    public static String getEmployeeCode() {
        return getContent(Constants.KEY_MA);
    }

    public static boolean saveUser(String UserInfo) {
        saveContent(Constants.KEY_USER, UserInfo);
        return true;
    }

    public static String getUser() {
        return getContent(Constants.KEY_USER);
    }

    public static String getContent(String key) {
        return prefs.getString(key, null);
    }

    public static void saveContent(String key, String value) {
        prefs.edit().putString(key, value).apply();
    }

}
