package com.common.commonbase;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.qline.common.R;
import com.common.commonview.SwipeBackLayout;


/**
 * Created by long on 2017/1/19.
 * 滑动退出Activity，参考：https://github.com/ikew0ng/SwipeBackLayout
 * 1、想要实现向右滑动删除Activity效果只需要继承SwipeBackActivity即可，如果当前页面含有ViewPager
 * 只需要调用SwipeBackLayout的setViewPager()方法即可
 * 2、设置activity的主题为android:theme="@style/CustomTransparent
 */
public abstract class SwipeBackActivity extends BaseActivity {

    private SwipeBackLayout mSwipeBackLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
                R.layout.base, null);
        mSwipeBackLayout.attachToActivity(this);
    }

}
