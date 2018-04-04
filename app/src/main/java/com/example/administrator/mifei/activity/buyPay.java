package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.ViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class buyPay extends BaseBackActivity {
    @Bind(R.id.list_test)
    ListView list_test;

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
        initHeaderView();
    }

    private void initHeaderView(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_item, null);
        ViewPager viewpager = (ViewPager)view.findViewById(R.id.headViewPager);
        List<ImageView> listtemp = new ArrayList<>();
        for(int i = 0;i<4;i++)
        {
            ImageView img = new ImageView(mContext);
            img.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,100));
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            img.setBackgroundResource(R.drawable.default_place_holder);
            listtemp.add(img);
        }
        ViewPageAdapter viewadapter = new ViewPageAdapter(listtemp);
        list_test.addHeaderView(view);
        list_test.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, data));
        viewpager.setAdapter(viewadapter);
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context,buyPay.class);
        context.startActivity(intent);
    }
}
