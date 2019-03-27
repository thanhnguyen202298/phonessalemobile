package com.aln.phonesaleschain.screen.login_qlnv.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.aln.phonesaleschain.datahelper.preferenceapi.PreferenceUtils;
import com.aln.phonesaleschain.screen.home.LoginView;
import com.aln.phonesaleschain.screen.home.model.UserInfo;
import com.aln.phonesaleschain.screen.home.presenter.LoginInteraterImpli;
import com.aln.phonesaleschain.screen.home.presenter.LoginInterator;
import com.aln.phonesaleschain.screen.home.presenter.LoginListener;
import net.grandcentrix.thirtyinch.TiPresenter;

public class LoginPresenterQLnv extends TiPresenter<LoginView> implements LoginListener {
    private LoginView inView;
    private LoginInterator interator;
    private Context context;
    private SaveLoginInfoInterator msaveData;

    public LoginPresenterQLnv(Context ctx) {
        context = ctx;
        interator = new LoginInteraterImpli();
        PreferenceUtils.getSharesPrefer(context);
        msaveData = new SaveLoginInfoInterator();

    }

    public void doLogin(String usn, String pwd) {
        interator.Login(usn, pwd, this);
    }

    @Override
    protected void onAttachView(@NonNull LoginView view) {
        super.onAttachView(view);
        inView = view;
        Log.e("<<<PRESSENTER : ", "ATTACH: ");
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
        msaveData.saveUserInfo(userInfo);

        inView.navigateToHome(userInfo);
    }

    @Override
    public void onLoginError(String msg) {
        inView.showMessage(msg);
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