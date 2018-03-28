package com.common.commonview.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.common.commonview.imageview.PhotoImageView;

/**
 * 处理 PhotoView 缩放异常的 ViewPager
 *
 * @author zhang
 * @time 2017/3/23 10:54
 */
public class HackyViewPager extends ViewPager {

    public HackyViewPager(Context context) {

        super(context);
    }

    public HackyViewPager(Context context, AttributeSet attrs) {

        super(context, attrs);
    }



    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {

        if (v instanceof PhotoImageView) {
            return ((PhotoImageView) v).canScrollHorizontallyFroyo(-dx);
        } else {
            return super.canScroll(v, checkV, dx, x, y);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
