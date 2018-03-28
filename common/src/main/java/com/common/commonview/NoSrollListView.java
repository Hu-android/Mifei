package com.common.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by liu 2016/8/3.
 * <p>
 * 该重写的listView解决固定GridView高度 存在多行textview时高度固定不准确的问题
 */
public class NoSrollListView extends ListView {
    public NoSrollListView(Context context) {
        this(context, null);
    }

    public NoSrollListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public NoSrollListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
