package com.example.administrator.mifei.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.mifei.R;

/**
 * TODO: document your custom view class.
 */
public class txt_et_img_item extends FrameLayout{
    private View mView;
    private TextView te_item_txt_left;
    private EditText te_item_et_left;

    public txt_et_img_item(Context context) {
        super(context);
        initView(context);
    }

    public txt_et_img_item(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initData(context, attrs);
    }

    public txt_et_img_item(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initData(context, attrs);
    }

    private void initView(Context context){
        mView = LayoutInflater.from(context).inflate(R.layout.txt_et_img_item,null);
        te_item_txt_left = (TextView) mView.findViewById(R.id.te_item_txt_left);
        te_item_et_left = (EditText) mView.findViewById(R.id.te_item_et_left);
        this.addView(mView);
    }

    private void initData(Context context,AttributeSet attrs){
        TypedArray ta1 = context.obtainStyledAttributes(attrs, R.styleable.txt_et_img_item_tei);
        String txt_item = ta1.getString(R.styleable.txt_et_img_item_tei_te_item_txt);
        String et_item = ta1.getString(R.styleable.txt_et_img_item_tei_te_item_et);
        te_item_txt_left.setText(txt_item);
        te_item_et_left.setHint(et_item);
        ta1.recycle();  //注意回收
    }
}
