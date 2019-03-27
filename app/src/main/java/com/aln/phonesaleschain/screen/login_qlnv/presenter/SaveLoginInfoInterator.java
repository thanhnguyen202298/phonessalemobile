package com.aln.phonesaleschain.screen.login_qlnv.presenter;

import com.aln.phonesaleschain.datahelper.preferenceapi.PreferenceUtils;
import com.aln.phonesaleschain.datahelper.webapi.APIUtils;
import com.aln.phonesaleschain.datahelper.webapi.PathApi;
import com.aln.phonesaleschain.screen.home.model.UserInfo;
import com.aln.phonesaleschain.utilities.UtilBasic;

public class SaveLoginInfoInterator {
    private PathApi mApi;
    public SaveLoginInfoInterator(){
        mApi = APIUtils.getService();
    }

    public void saveUserInfo(UserInfo userInfo){
        PreferenceUtils.saveUser(UtilBasic.ObjectToJson(userInfo));
    }
}
