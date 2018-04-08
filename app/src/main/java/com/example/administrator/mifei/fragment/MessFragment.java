package com.example.administrator.mifei.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.common.commonbase.BaseFragment;
import com.example.administrator.mifei.R;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.Bind;


public class MessFragment extends BaseFragment{

    @Bind(R.id.tab_layout_mess)
    SegmentTabLayout tab_layout_mess;
    @Bind(R.id.vp_mess)
    ViewPager vp_mess;
    private String[] mTitles = {"首页", "消息"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mess;
    }

    @Override
    protected void initView() {
        tab_layout_mess();
        tab_layout_mess.setTabData(mTitles);
    }

    private void tab_layout_mess(){
       // vp_mess.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        tab_layout_mess.setTabData(mTitles);
        tab_layout_mess.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp_mess.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        vp_mess.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tab_layout_mess.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp_mess.setCurrentItem(1);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
