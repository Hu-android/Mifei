package com.example.administrator.mifei.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.common.commonutil.GlideCircleTransform;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.utils.ClickListener;

/**
 * Created by Administrator on 2018/4/11 0011.
 */

public class txt_head_img_item extends FrameLayout {
    private RequestManager glideRequest;
    private View mView;
    private ClickListener clickListener;
    private RelativeLayout txt_head_img_item;
    private TextView tii_item_txt_left;
    private ImageView tii_item_img_head,tii_item_img_enter;

    public txt_head_img_item(Context context) {
        super(context);
        initView(context);
    }

    public txt_head_img_item(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initData(context, attrs);
    }

    public txt_head_img_item(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initData(context, attrs);
    }

    private void initView(Context context){
        mView = LayoutInflater.from(context).inflate(R.layout.txt_head_img_item,null);
        txt_head_img_item = (RelativeLayout) mView.findViewById(R.id.txt_head_img_item);
        tii_item_img_enter = (ImageView) mView.findViewById(R.id.tii_item_img_enter);
        tii_item_txt_left = (TextView) mView.findViewById(R.id.tii_item_txt_left);
        tii_item_img_head = (ImageView) mView.findViewById(R.id.tii_item_img_head);
        txt_head_img_item.setOnClickListener(new OnClickListener() {
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
        TypedArray ta1 = context.obtainStyledAttributes(attrs, R.styleable.txt_head_img_item_tii);
        String txt_item = ta1.getString(R.styleable.txt_head_img_item_tii_tii_item_txt);
        Drawable head_item = ta1.getDrawable(R.styleable.txt_head_img_item_tii_tii_item_head);
        Log.d("——————————",R.styleable.txt_head_img_item_tii_tii_item_head+"");
        tii_item_txt_left.setText(txt_item);
        tii_item_img_head.setImageDrawable(head_item);
//        glideRequest = Glide.with(context);
//        glideRequest.load(head_item).transform(new GlideCircleTransform(context)).into(tii_item_img_head);
        ta1.recycle();  //注意回收
    }
}
