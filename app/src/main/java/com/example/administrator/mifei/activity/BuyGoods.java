package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.common.commonbase.BaseBackActivity;
import com.common.commonutil.LogUtils;
import com.common.commonview.viewpager.UnScrollViewPager;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.bean.TabEntity;
import com.example.administrator.mifei.fragment.MessFragment;
import com.example.administrator.mifei.fragment.MineFragment;
import com.example.administrator.mifei.fragment.YuncangFragment;
import com.example.administrator.mifei.fragment.ZhigouFragment;
import com.example.administrator.mifei.fragment.caseBuyFragment;
import com.example.administrator.mifei.fragment.singleBuyFragment;
import com.example.administrator.mifei.main.MainActivity;
import com.example.administrator.mifei.utils.ViewFindUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;


import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;

public class BuyGoods extends BaseBackActivity {

    public static final String TAG = "BuyGoods";

    @Bind(R.id.tab_layout_buy_goods)
    public CommonTabLayout tabLayoutBuyGoods;
    @Bind(R.id.view_paper_buy_goods)
    UnScrollViewPager viewPager;

    private final int[] mTitles = {
            R.string.tv_zhengxiang,R.string.tv_danbao};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

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

    public void initTab(){
        for (int i = 0;i < mTitles.length;i++){
            mTabEntities.add(new TabEntity(getString(mTitles[i])));
        }

        View mDecorView = getWindow().getDecorView();
        tabLayoutBuyGoods = ViewFindUtils.find(mDecorView,R.id.tab_layout_buy_goods);

        tabLayoutBuyGoods.setTabData(mTabEntities);
        //点击监听
        tabLayoutBuyGoods.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                SwitchTo(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
        initViewPager();
    }
    /**
     * 切换fragment
     */
    private void SwitchTo(int position) {
        LogUtils.d(TAG, "主页菜单position" + position);
        viewPager.setCurrentItem(position, false);
    }

    private void initViewPager() {
        viewPager.setOffscreenPageLimit(mTitles.length);
        BuyGoods.MyPagerAdapter pageAdapter = new BuyGoods.MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
        tabLayoutBuyGoods.setCurrentTab(0);
        viewPager.setCurrentItem(0, false);
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
                case 0://整箱装
                    fragment = new caseBuyFragment();
                    break;
                case 1://单包装
                    fragment = new singleBuyFragment();
                    break;
                default:
                    break;
            }
            return fragment;
        }
    }

}
