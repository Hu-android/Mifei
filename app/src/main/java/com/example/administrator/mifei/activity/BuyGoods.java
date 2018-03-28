package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;

public class BuyGoods extends BaseBackActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_buy_goods;
    }

    @Override
    public String getTitleName() {
        return "提货";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    public static void toActivity(Context context){
        Intent intent = new Intent(context,BuyGoods.class);
        context.startActivity(intent);
    }
}
