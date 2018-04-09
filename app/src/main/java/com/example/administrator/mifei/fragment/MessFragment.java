package com.example.administrator.mifei.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.common.commonbase.BaseFragment;
import com.example.administrator.mifei.R;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class MessFragment extends BaseFragment {

    @Bind(R.id.tab_layout_mess)
    SegmentTabLayout tab_layout_mess;
    @Bind(R.id.vp_mess)
    ViewPager vp_mess;
    companyMesFragment companyMesFragment;
    agentMesFragment agentMesFragment;
    ArrayList<Fragment> fragmentList;



    private String[] mTitles = {"   代理消息   ", "   公司消息   "};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mess;
    }

    @Override
    protected void initView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new agentMesFragment());
        fragmentList.add(new companyMesFragment());
        tab_layout_mess.setTabData(mTitles);
        tab_layout_mess.showDot(1);
        vp_mess.setAdapter(new MyAdapter(getChildFragmentManager(),fragmentList));
        setTab_layout_mess();
    }

    public void setTab_layout_mess(){
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

   /* private void tab_layout_mess() {
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
    }*/

    class  MyAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragment;

        public MyAdapter(FragmentManager fm, List<Fragment>fragments) {
            super(fm);
            fragment=fragments;
        }


        @Override
        public Fragment getItem(int position) {
            return fragment.get(position);
        }

        @Override
        public int getCount() {
            return fragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
