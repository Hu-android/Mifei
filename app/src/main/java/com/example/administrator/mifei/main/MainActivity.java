package com.example.administrator.mifei.main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.common.commonbase.BaseMainActivity;
import com.common.commonutil.LogUtils;
import com.common.commonview.viewpager.UnScrollViewPager;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.activity.Pwd_Reset;
import com.example.administrator.mifei.bean.TabEntity;
import com.example.administrator.mifei.fragment.MessFragment;
import com.example.administrator.mifei.fragment.MineFragment;
import com.example.administrator.mifei.fragment.YuncangFragment;
import com.example.administrator.mifei.fragment.ZhigouFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.Timer;

import butterknife.Bind;

public class MainActivity extends BaseMainActivity {

    public static final String TAG = "MainActivity";

    @Bind(R.id.tab_layout)
    public CommonTabLayout tabLayout;

    @Bind(R.id.view_paper)
    UnScrollViewPager viewPager;

    private int[] mTitles = {
            R.string.tv_yuncang,R.string.tv_zhigou,R.string.tv_mess,R.string.tv_mine};
    private int[] mIconUnselectIds = {
            R.drawable.iconyuncang_1,R.drawable.iconzhigou_1,R.drawable.iconmsg_1,R.drawable.iconmine_1};
    private int[] mIconSelectIds = {
            R.drawable.iconyuncang_2,R.drawable.iconzhigou_2,R.drawable.iconmsg_2,R.drawable.iconmine_2};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        initTab();
    }

    /**
     * 初始化导航栏
     */
    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(getResources().getString(mTitles[i]), mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //点击监听
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
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
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
        tabLayout.setCurrentTab(0);
        viewPager.setCurrentItem(0, false);
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }

    private class PageAdapter extends FragmentPagerAdapter {


        public PageAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            switch (position) {
                case 0://首页
                    fragment = new YuncangFragment();
                    break;
                case 1://云仓
                    fragment = new ZhigouFragment();
                    break;
                case 2://消息
                    fragment = new MessFragment();
                    break;
                case 3://我的
                    fragment = new MineFragment();
                    break;

                default:
                    break;
            }

            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return getResources().getString(mTitles[position]);
        }

        @Override
        public int getCount() {

            return mTitles.length;
        }
    }
}
