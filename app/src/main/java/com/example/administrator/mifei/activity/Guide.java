package com.example.administrator.mifei.activity;

import android.content.Intent;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.VpAdapter;
import com.example.administrator.mifei.view.BaseActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;

public class Guide extends com.common.commonbase.BaseActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.guide_ViewPager)
    ViewPager guide_ViewPager;
    VpAdapter vpAdapter;
    private static int[] imgs = {R.drawable.details1, R.drawable.details2, R.drawable.details3};
    private ArrayList<ImageView> imageViews;
    private ImageView[] dotViews;

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initImages();
        initDots();
        vpAdapter = new VpAdapter(imageViews);
        guide_ViewPager.setAdapter(vpAdapter);
        guide_ViewPager.addOnPageChangeListener(this);
    }

    private void initDots(){
        LinearLayout layout = (LinearLayout)findViewById(R.id.dot_layout);
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(20, 20);
        mParams.setMargins(10, 0, 10,0);//设置小圆点左右之间的间隔
        dotViews = new ImageView[imgs.length];
        //判断小圆点的数量，从0开始，0表示第一个
        for(int i = 0; i < imageViews.size(); i++)
        {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(mParams);
            imageView.setImageResource(R.drawable.dotselector);
            if(i== 0)
            {
                imageView.setSelected(true);//默认启动时，选中第一个小圆点
            }
            else {
                imageView.setSelected(false);
            }
            dotViews[i] = imageView;//得到每个小圆点的引用，用于滑动页面时，（onPageSelected方法中）更改它们的状态。
            layout.addView(imageView);//添加到布局里面显示
        }

    }

    private void initImages() {
        //设置每一个页面都有一张图片填充
        ViewPager.LayoutParams params = new ViewPager.LayoutParams();
        imageViews = new ArrayList<ImageView>();

        for (int i = 0; i < imgs.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(params);//设置布局
            iv.setImageResource(imgs[i]);//选择相应的图片资源
            iv.setScaleType(ImageView.ScaleType.FIT_XY);//自适应
            imageViews.add(iv);
            if (i == imgs.length - 1) {
                //为最后一张图片添加点击事件
                iv.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        //跳转到主界面
                        Intent toMainActivity = new Intent(Guide.this, Login.class);
                        startActivity(toMainActivity);
                        return true;
                    }
                });
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotViews.length; i++) {
            if (position == i) {
                dotViews[i].setSelected(true);
            } else {
                dotViews[i].setSelected(false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
