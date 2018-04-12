package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.utils.ClickListener;
import com.example.administrator.mifei.view.txt_head_img_item;
import com.example.administrator.mifei.view.txt_img_item;

import butterknife.Bind;

public class Setting extends BaseBackActivity{
    @Bind(R.id.headChange)
    txt_head_img_item headChange;
    @Bind(R.id.pwdChange)
    txt_img_item pwdChange;


    public static void toActivity(Context context) {
        Intent intent = new Intent(context,Setting.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public String getTitleName() {
        return "设置";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        headChange.setCustomOnClickListener(new ClickListener() {
            @Override
            public void Click(View v) {
                Toast.makeText(mContext,"更改头像",Toast.LENGTH_SHORT).show();
            }
        });
        pwdChange.setCustomOnClickListener(new ClickListener() {
            @Override
            public void Click(View v) {
                PwdChange.toActivity(mContext);
            }
        });
    }

}
