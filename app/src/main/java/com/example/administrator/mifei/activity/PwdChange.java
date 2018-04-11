package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;

import butterknife.Bind;

public class PwdChange extends BaseBackActivity implements View.OnClickListener{
    @Bind(R.id.btn_pwd_change)
    Button btnPwdChange;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pwd_change;
    }

    @Override
    public String getTitleName() {
        return "修改密码";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    public static void toActivity(Context context){
        Intent intent = new Intent(context,PwdChange.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}
