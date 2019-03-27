package com.aln.phonesaleschain.screen.home.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import com.aln.phonesaleschain.screen.home.LoginView;
import com.aln.phonesaleschain.screen.home.model.UserInPrefs;
import com.aln.phonesaleschain.screen.home.model.UserInfo;
import com.aln.phonesaleschain.screen.home.model.UserLogin;

import net.grandcentrix.thirtyinch.TiPresenter;

public class LoginPresenter extends TiPresenter<LoginView> implements LoginListener {

    private LoginView inView;
    private LoginInterator interator;
    private Context context;
    private UserLogin usnfo;

    public LoginPresenter(Context ctx) {
//        myprefs = PreferenceUtils.getSharesPrefer(ctx);
        usnfo = new UserInPrefs(ctx);
        context = ctx;
        interator = new LoginInteraterImpli();
    }

    @Override
    protected void onAttachView(@NonNull LoginView view) {
        super.onAttachView(view);
        inView = view;
        if (usnfo == null) {
            onLoginError("vui lòng đăng nhập");
        } else
            interator.Login(usnfo.getUser(), usnfo.getPass(), this);
        Log.e("<<<PRESSENTER : ", "ATACH: " + usnfo.getUser());
    }

    public void ShowToView(String daa) {
        inView.showMessage(daa);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("<<<PRESSENTER : ", "destroy");
    }

    @Override
    protected void onDetachView() {
        super.onDetachView();
        Log.e("<<<PRESSENTER : ", "DDETACH");
    }

    @Override
    public void onLoginSuccess(UserInfo userInfo) {
        inView.showMessage("success login");
        inView.navigateToHome(userInfo);

    }

    @Override
    public void onLoginError(String msg) {
        inView.showMessage(msg);
        inView.navigateToLogin();
    }

    @Override
    public boolean validUser(String user) {
        return false;
    }

    @Override
    public boolean validPass(String pass) {
        return false;
    }
}