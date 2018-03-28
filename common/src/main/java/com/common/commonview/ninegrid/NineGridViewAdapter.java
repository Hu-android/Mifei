package com.common.commonview.ninegrid;

import android.content.Context;
import android.widget.ImageView;

import com.qline.common.R;

import java.util.List;

public abstract class NineGridViewAdapter<T>{

    public NineGridViewAdapter() {
    }

    protected abstract void onDisplayImage(Context context, ImageView imageView,int index, T t);

    protected void onItemImageClick(Context context, ImageView imageView, int index, List<T> list) {
    }

    protected ImageView generateImageView(Context context) {
        NineGridViewWrapper imageView = new NineGridViewWrapper(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.default_place_holder);
        return imageView;
    }
}