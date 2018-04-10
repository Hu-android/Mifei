package com.example.administrator.mifei.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mifei.R;

import org.w3c.dom.Attr;
import org.w3c.dom.Text;

public class MineOrder extends LinearLayout {
    private View mView;
    TextView purchaseorder_item,lowerorder_item,pickorder_item,zhigouorder_item;

    public MineOrder(Context context) {
        super(context);
        initView(context);
    }

    public MineOrder(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initData(context,attrs);
    }

    public MineOrder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initData(context,attrs);
    }

    private void initView(Context context){
        mView = LayoutInflater.from(context).inflate(R.layout.mine_order_item,null);
        purchaseorder_item = (TextView)mView.findViewById(R.id.purchaseorder_item);
        lowerorder_item = (TextView)mView.findViewById(R.id.lowerorder_item);
        pickorder_item = (TextView)mView.findViewById(R.id.pickorder_item);
        zhigouorder_item = (TextView)mView.findViewById(R.id.zhigouorder_item);
        this.addView(mView);
    }

    private void initData(Context context, AttributeSet attrs){

    }
}
