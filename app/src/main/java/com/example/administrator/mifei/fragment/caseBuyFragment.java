package com.example.administrator.mifei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.commonbase.BaseFragment;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.caseAdapter;
import com.example.administrator.mifei.bean.GoodsInfoModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public class caseBuyFragment extends BaseFragment {
    @Bind(R.id.case_listView)
    RecyclerView case_listView;
    private caseAdapter adapter;
    private List<GoodsInfoModel.goodsInfo_Buy> buys = new ArrayList<>();

    private int[] goodsImages = {R.drawable.default_place_holder,R.drawable.default_place_holder,R.drawable.default_place_holder,R.drawable.default_place_holder,
            R.drawable.default_place_holder,R.drawable.default_place_holder};
    private String[] goodsName = {"米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤",
            "米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤"};
    private double[] goodsPrice = {50,100,150,200,350,124};
    private double[] goodsPriceHigher = {100,120,158,124,315,219};
    private int[] goodsInventory = {100,100,100,110,100,100};

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_case_buy;
    }

    @Override
    protected void initView() {
        initData();
        adapter = new caseAdapter(mContext,buys);
        case_listView.setAdapter(adapter);

        case_listView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
    }

    private void initData(){
        for (int i = 0;i<goodsImages.length;i++){
            buys.add(new GoodsInfoModel.goodsInfo_Buy(goodsName[i],goodsPrice[i],goodsPriceHigher[i],goodsInventory[i],goodsImages[i]));
        }

    }
}
