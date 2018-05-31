package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.ViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class buyPay extends BaseBackActivity {
    @Bind(R.id.list_test)
    ListView list_test;
    TextView txt_title;

    private final String data[] = { "one", "two", "three", "four", "five", "six", "seven" };
    @Override
    public int getLayoutId() {
        return R.layout.activity_buy_pay;
    }

    @Override
    public String getTitleName() {
        return "确认订单";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        String tel = bundle.getString("txt_title");
        initHeaderView();
        txt_title.setText(tel);
    }
    private void initHeaderView(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.yc_title_list_item, null);
        txt_title = (TextView) view.findViewById(R.id.yc_title_list_item);
        list_test.addHeaderView(view);
        list_test.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, data));
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context,buyPay.class);
        context.startActivity(intent);
    }
}
