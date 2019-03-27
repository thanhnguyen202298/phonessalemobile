package com.aln.phonesaleschain.screen.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.aln.phonesaleschain.screen.main.MainActivity;
import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.screen.home.model.UserInfo;
import com.aln.phonesaleschain.screen.home.presenter.LoginPresenter;
import com.aln.phonesaleschain.screen.login_qlnv.LoginQLNV;
import com.aln.phonesaleschain.service.WakeServiceSSk;
import net.grandcentrix.thirtyinch.TiActivity;

public class HomeActivity extends TiActivity<LoginPresenter,LoginView> implements LoginView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    //check login with api data


    @NonNull
    @Override
    public LoginPresenter providePresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void navigateToHome(UserInfo userInfo) {
        if (userInfo.GroupID == 1 || userInfo.GroupID == 2) {
            Intent navigateToAdminPage = new Intent(HomeActivity.this, MainActivity.class);
            navigateToAdminPage.putExtra("Name", userInfo.EmployeeName);
            navigateToAdminPage.putExtra("Depart", userInfo.DivisionName);
            navigateToAdminPage.putExtra("Empcode", userInfo.EmployeeCode);
            startActivity(navigateToAdminPage);
            finish();
        } else {
            //check with group id # 1 & 2
            WakeServiceSSk.onWWake(HomeActivity.this, userInfo.EmployeeCode);
            Intent navigateToUser = new Intent(HomeActivity.this, MainActivity.class);
            navigateToUser.putExtra("Name", userInfo.EmployeeName);
            navigateToUser.putExtra("Depart", userInfo.DivisionName);
            navigateToUser.putExtra("Empcode", userInfo.EmployeeCode);
            navigateToUser.putExtra("Role", "" + userInfo.GroupID);
            startActivity(navigateToUser);
            finish();
        }
    }

    @Override
    public void navigateToLogin() {
        Intent navigateToLogin = new Intent(HomeActivity.this, LoginQLNV.class);
        startActivity(navigateToLogin);
        finish();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean show) {

    }
}
