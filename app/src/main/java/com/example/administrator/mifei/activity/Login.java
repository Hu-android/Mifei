package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.main.MainActivity;

import butterknife.OnClick;


public class Login extends BaseBackActivity{

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
                MainActivity.toActivity(mContext);
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
