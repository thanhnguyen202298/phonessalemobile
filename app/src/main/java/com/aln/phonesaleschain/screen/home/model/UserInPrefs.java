package com.aln.phonesaleschain.screen.home.model;

import android.content.Context;

import com.aln.phonesaleschain.datahelper.preferenceapi.PreferenceUtils;
import com.aln.phonesaleschain.utilities.UtilBasic;

public class UserInPrefs implements UserLogin{
    public UserInfo user;

    public UserInPrefs(Context context){
        PreferenceUtils.getSharesPrefer(context);
        user = UtilBasic.getGs().fromJson(PreferenceUtils.getUser(),UserInfo.class);
    }
    @Override
    public String getUser() {
        return user.UserName;
    }

    @Override
    public String getPass() {
        return user.Pass;
    }
}
