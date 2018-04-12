package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;

public class MineAddressUpdate extends BaseBackActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_address_update;
    }

    @Override
    public String getTitleName() {
        return "编辑地址";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context,MineAddressUpdate.class);
        context.startActivity(intent);
    }
}
