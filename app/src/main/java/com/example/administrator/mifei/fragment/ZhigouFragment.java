package com.example.administrator.mifei.fragment;


import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.common.commonbase.BaseFragment;
import com.common.commonbase.BaseTitleBackFragment;
import com.common.commonutil.StatusBarCompat;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.ViewPageAdapter;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class ZhigouFragment extends BaseFragment{

    private DrawerLayout tran_drawer_drawer;
    private Toolbar tran_drawer_toolbar;
    private ActionBarDrawerToggle toggle;
    @Bind(R.id.list_zhigou)
    ListView list_zhigou;

    private final String data[] = { "one", "two", "three", "four", "five", "six", "seven" };

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_zhigou;
    }

    @Override
    protected void initView() {
        initHeaderView();

    }

    private void initHeaderView(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_item, null);
        ViewPager viewpager = (ViewPager)view.findViewById(R.id.headViewPager);
        List<ImageView> listtemp = new ArrayList<>();
        for(int i = 0;i<4;i++)
        {
            ImageView img = new ImageView(mContext);
            img.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,100));
            img.setScaleType(ScaleType.FIT_XY);
            img.setBackgroundResource(R.drawable.default_place_holder);
            listtemp.add(img);
        }
        ViewPageAdapter viewadapter = new ViewPageAdapter(listtemp);
        list_zhigou.addHeaderView(view);
        list_zhigou.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, data));
        viewpager.setAdapter(viewadapter);
    }
}
