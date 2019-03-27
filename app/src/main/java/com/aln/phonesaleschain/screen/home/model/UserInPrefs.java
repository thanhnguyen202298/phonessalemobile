package com.aln.phonesaleschain.screen.home.model;

import android.content.Context;

import com.aln.phonesaleschain.datahelper.preferenceapi.PreferenceUtils;

public class UserInPrefs implements UserLogin{
    public String user;
    public String pass;

    public UserInPrefs(Context context){
        PreferenceUtils.getSharesPrefer(context);
        user = PreferenceUtils.getUserName();
        pass = PreferenceUtils.getPassword();
    }
    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPass() {
        return pass;
    }
}
