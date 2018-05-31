package com.example.administrator.mifei.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.bean.LoginBean;
import com.example.administrator.mifei.bean.UserBean;
import com.example.administrator.mifei.http.ApiManager;
import com.example.administrator.mifei.http.BaseCallBack;
import com.example.administrator.mifei.http.OkHttpTools;
import com.example.administrator.mifei.main.MainActivity;
import com.example.administrator.mifei.utils.L;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Login extends BaseBackActivity{

    @Bind(R.id.txt_hint_mobile)
    TextView txt_hint_mobile;
    @Bind(R.id.txt_hint_pwd)
    TextView txt_hint_pwd;

    public static final String TAG = "Login_activity";

    //绑定布局文件
    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    //设置标题
    @Override
    public String getTitleName() {
        return "会员登陆-米菲";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {


    }

    @OnClick({R.id.pwd_forget,R.id.btn_login})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.pwd_forget:
                Pwd_Reset.toActivity(mContext);
                break;
            case R.id.btn_login:
                final String userName = txt_hint_mobile.getText().toString().trim();
                final String pwd = txt_hint_pwd.getText().toString().trim();
                if (TextUtils.isEmpty(userName))
                {
                    Toast.makeText(Login.this,"请输入帐号",Toast.LENGTH_SHORT).show();

                    return;
                }else if(TextUtils.isEmpty(pwd)){
                    Toast.makeText(Login.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder
                        .get()
                        .url(ApiManager.LOGIN+"?userName="+userName+"&pwd="+pwd)
                        .build();

                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        L.e("onFailure" + e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        L.e("onResponse");

                        final String res = response.body().string();
                        LoginBean loginBean = new Gson().fromJson(res, LoginBean.class);
                        UserBean userBeen = loginBean.getData();
                        L.e(res);
                        if (loginBean.getCode()==0){
                            MainActivity.toActivity(mContext);
                        }else{
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    L.e(ApiManager.LOGIN+"?userName="+userName+"&pwd="+pwd);
                                    Toast.makeText(Login.this,"帐号密码错误",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                    }
                });

                break;
        }
    }

    //别的Activity跳转到这个页面调用的方法
   /* public static void toActivity(Context context, User user) {
        Intent intent = new Intent(context, UserInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }*/
}
