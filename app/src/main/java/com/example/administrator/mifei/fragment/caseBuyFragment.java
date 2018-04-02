package com.example.administrator.mifei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.mifei.R;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public class caseBuyFragment extends Fragment {
    private String mTitle;

    public static caseBuyFragment getInstance(String title){
        caseBuyFragment caseBuy = new caseBuyFragment();
        caseBuy.mTitle = title;
        return caseBuy;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_case_buy,null);
        TextView card_title_tv = (TextView) view.findViewById(R.id.card_title_tv);
        card_title_tv.setText(mTitle);
        return view;
    }
}
