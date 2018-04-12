package com.example.administrator.mifei.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mifei.R;
import com.example.administrator.mifei.utils.ClickListener;

/**
 * Created by Administrator on 2018/4/11 0011.
 */

public class txt_img_item extends FrameLayout {
    private View mView;
    private RelativeLayout txt_img_item;
    private ClickListener clickListener;
    private TextView ti_item_txt_left;

    public txt_img_item(Context context) {
        super(context);
        initView(context);
    }

    public txt_img_item(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initData(context, attrs);
    }

    public txt_img_item(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initData(context, attrs);
    }

    private void initView(Context context){
        mView = LayoutInflater.from(context).inflate(R.layout.txt_img_item,null);
        txt_img_item = (RelativeLayout) mView.findViewById(R.id.txt_img_item);
        ti_item_txt_left = (TextView) mView.findViewById(R.id.ti_item_txt_left);
        txt_img_item.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null){
                    clickListener.Click(v);
                }
            }
        });
        this.addView(mView);
    }

    public void setCustomOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    private void initData(Context context,AttributeSet attrs){
        TypedArray ta1 = context.obtainStyledAttributes(attrs, R.styleable.txt_img_item_ti);
        String txt_item = ta1.getString(R.styleable.txt_img_item_ti_ti_item_txt);
        ti_item_txt_left.setText(txt_item);
        ta1.recycle();  //注意回收
    }


}
