package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.utils.ClickListener;
import com.example.administrator.mifei.view.txt_img_item;

import butterknife.Bind;

public class MineComprehensive extends BaseBackActivity{
    @Bind(R.id.btn_receive_address)
    txt_img_item btn_receive_address;
    @Bind(R.id.btn_wechat_binding)
    txt_img_item btn_wechat_binding;
    @Bind(R.id.btn_problem_update)
    txt_img_item btn_problem_update;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_comprehensive;
    }

    @Override
    public String getTitleName() {
        return "综合业务";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        btn_receive_address.setCustomOnClickListener(new ClickListener() {
            @Override
            public void Click(View v) {
                MineReceiveAddress.toActivity(mContext);
                Toast.makeText(mContext,"收货地址",Toast.LENGTH_SHORT).show();
            }
        });
        btn_wechat_binding.setCustomOnClickListener(new ClickListener() {
            @Override
            public void Click(View v) {
                Toast.makeText(mContext,"微信绑定",Toast.LENGTH_SHORT).show();
            }
        });
        btn_problem_update.setCustomOnClickListener(new ClickListener() {
            @Override
            public void Click(View v) {
                Toast.makeText(mContext,"问题反馈",Toast.LENGTH_SHORT).show();
            }
        });
    }



    public static void toActivity(Context context) {
        Intent intent = new Intent(context,MineComprehensive.class);
        context.startActivity(intent);
    }

}
