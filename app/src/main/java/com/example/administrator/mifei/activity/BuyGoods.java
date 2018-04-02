package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.bean.TabEntity;
import com.example.administrator.mifei.fragment.caseBuyFragment;
import com.example.administrator.mifei.utils.ViewFindUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.Bind;

public class BuyGoods extends BaseBackActivity {

    private ArrayList<Fragment>mFragment = new ArrayList<>();
    private MyPagerAdapter mAdapter;
   /* @Bind(R.id.tab_layout_buy_goods)
    public SlidingTabLayout tabLayoutBuyGoods;*/

    private final String[] mTitles = {
            "整箱装","单包装"};

    public void initTab(){
        for (String title : mTitles){
            mFragment.add(caseBuyFragment.getInstance(title));
        }

        View decorView = getWindow().getDecorView();
        ViewPager vp = ViewFindUtils.find(decorView,R.id.vp);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);

        SlidingTabLayout tabLayout = ViewFindUtils.find(decorView,R.id.tab_layout_buy_goods);

        tabLayout.setViewPager(vp);
    }

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
        initTab();
    }

    public static void toActivity(Context context){
        Intent intent = new Intent(context,BuyGoods.class);
        context.startActivity(intent);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }
    }
}
