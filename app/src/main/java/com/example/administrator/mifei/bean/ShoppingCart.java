package com.example.administrator.mifei.bean;

import android.view.View;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public interface ShoppingCart {
    void add(View view, int position);
    void remove(View view, int position);
}
