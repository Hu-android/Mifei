package com.common.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by liu 2016/8/3.
 *
 * 该重写的listView解决固定GridView高度 存在多行textview时高度固定不准确的问题
 *
 */
public class NoSrollGridView extends GridView {
    public NoSrollGridView(Context context) {
        super(context);
    }

    public NoSrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public NoSrollGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
