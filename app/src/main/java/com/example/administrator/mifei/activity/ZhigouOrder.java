package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.bean.TabEntity;
import com.example.administrator.mifei.utils.ViewFindUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.Bind;

public class ZhigouOrder extends BaseBackActivity {
    public static final String TAG = "ZhigouOrder";
    @Bind(R.id.tab_layout_Zhigou_order)
    CommonTabLayout tab_layout_Zhigou_order;
    @Bind(R.id.vp_Zhigou_order)
    ViewPager vp_Zhigou_order;

    private final int[] mTitles = {
            R.string.tv_all,R.string.tvUnpay,R.string.tvLack,R.string.tvComplete};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_zhigou_order;
    }

    @Override
    public String getTitleName() {
        return "提货订单";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        Log.d(TAG,"ZhigouOrder——————>");
        setVp_Zhigou_order();
    }

    public void setVp_Zhigou_order(){
        for (int i = 0;i < mTitles.length;i++){
            mTabEntities.add(new TabEntity(getString(mTitles[i])));
        }

        View mDecorView = getWindow().getDecorView();
        tab_layout_Zhigou_order = ViewFindUtils.find(mDecorView,R.id.tab_layout_Zhigou_order);

        tab_layout_Zhigou_order.setTabData(mTabEntities);
        //点击监听
        tab_layout_Zhigou_order.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp_Zhigou_order.setCurrentItem(position, false);
            }

            @Override
            public void onTabReselect(int position) {}
        });
        vp_Zhigou_order.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tab_layout_Zhigou_order.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initViewPager();
    }

    private void initViewPager() {
        vp_Zhigou_order.setOffscreenPageLimit(mTitles.length);
        ZhigouOrder.MyPagerAdapter pageAdapter = new ZhigouOrder.MyPagerAdapter(getSupportFragmentManager());
        vp_Zhigou_order.setAdapter(pageAdapter);
        tab_layout_Zhigou_order.setCurrentTab(0);
        vp_Zhigou_order.setCurrentItem(0, false);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getResources().getString(mTitles[position]);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0://全部
                    fragment = new orderAll();
                    break;
                case 1://待充值
                    fragment = new orderAll();
                    break;
                case 2://上级缺货
                    fragment = new orderAll();
                    break;
                case 3://已完成
                    fragment = new orderAll();
                    break;
                default:
                    break;
            }
            return fragment;
        }
    }

    public static void toActivity(Context context){
        Intent intent = new Intent(context,ZhigouOrder.class);
        context.startActivity(intent);
    }
}
