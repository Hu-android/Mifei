package com.example.administrator.mifei.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mifei.R;

import org.w3c.dom.Text;

import butterknife.Bind;

/**
 * Created by Administrator on 2018/3/22.
 */

public class Yc_Top_group extends FrameLayout{
    private View mView;
    private ImageView img_1;
    private TextView txt_1,txt_2;
    public Yc_Top_group(Context context) {
        super(context);
        initView(context);
    }

    public Yc_Top_group(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initData(context, attrs);
    }

    public Yc_Top_group(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initData(context, attrs);
    }


    private void initView(Context context){
        mView       = LayoutInflater.from(context).inflate(R.layout.yc_top_view,null);
        img_1 = (ImageView)mView.findViewById(R.id.Yc_Top_img);
        txt_1 = (TextView)mView.findViewById(R.id.Yc_Top_title1);
        txt_2 = (TextView)mView.findViewById(R.id.Yc_Top_title2);
        this.addView(mView);
    }

    private void initData(Context context,AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Yc_Top_group);
        String topText = ta.getString(R.styleable.Yc_Top_group_top_title);
        String bottomText = ta.getString(R.styleable.Yc_Top_group_bottom_title);
        Drawable img_src = ta.getDrawable(R.styleable.Yc_Top_group_img_src);
        txt_1.setText(topText);
        txt_2.setText(bottomText);
        img_1.setImageDrawable(img_src);
        ta.recycle();  //注意回收
    }
}
