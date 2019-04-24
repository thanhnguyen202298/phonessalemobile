package com.aln.phonesaleschain.screen.home.presenter;

import com.aln.phonesaleschain.datahelper.webapi.APIUtils;
import com.aln.phonesaleschain.datahelper.webapi.PathApi;
import com.aln.phonesaleschain.datahelper.webapi.ResultApi;
import com.aln.phonesaleschain.screen.home.model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteraterImpli implements LoginInterator {
    @Override
    public void Login(final String user, final String pass, final LoginListener listener) {
        PathApi mApi = APIUtils.getService();
        UserInfo u = new UserInfo();
        u.UserName = user;
        u.Pass = pass;
        mApi.getStatusLogin(u).enqueue(new Callback<ResultApi<List<UserInfo>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<UserInfo>>> call, Response<ResultApi<List<UserInfo>>> response) {

                if (response.body() != null) {
                    ResultApi<List<UserInfo>> usinfo = response.body();
                    if (usinfo.getStatus() > 0 && usinfo.data.size() > 0) {
                        UserInfo m = usinfo.data.get(0);
                        listener.onLoginSuccess(m);
                    } else listener.onLoginError("không có dữ liệu");
                } else listener.onLoginError("không có thông tin đăng nhập");
            }

            @Override
            public void onFailure(Call<ResultApi<List<UserInfo>>> call, Throwable t) {
                listener.onLoginError("lỗi kết nối");
            }
        });
    }
}
