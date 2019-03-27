package com.aln.phonesaleschain.screen.home.presenter;


import com.aln.phonesaleschain.screen.home.model.UserInfo;

public interface LoginListener {
    void onLoginSuccess(UserInfo userInfo);
    void onLoginError(String msg);
    boolean validUser(String user);
    boolean validPass(String pass);
}
