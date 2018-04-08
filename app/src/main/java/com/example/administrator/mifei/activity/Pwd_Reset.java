package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;

public class Pwd_Reset extends BaseBackActivity {

    public static final String TAG = "Pwd_Reset_activity";

    @Override
    public int getLayoutId() {
        return R.layout.activity_pwd_reset;
    }

    @Override
    public String getTitleName() {
        return "密码重设";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context,Pwd_Reset.class);
        context.startActivity(intent);
    }
}
