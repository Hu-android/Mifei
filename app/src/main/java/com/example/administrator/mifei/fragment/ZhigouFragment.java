package com.example.administrator.mifei.fragment;


import android.widget.ListView;

import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.GoodsAdapter;
import com.example.administrator.mifei.bean.GoodsInfoModel;
import com.example.administrator.mifei.view.BaseGoodsGroup;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class ZhigouFragment extends BaseGoodsGroup {

    @Bind(R.id.list1)
    ListView listView;
    private  List<GoodsInfoModel.goodsInfo_YCKCTop> info = new ArrayList<GoodsInfoModel.goodsInfo_YCKCTop>();
    GoodsAdapter adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_zhigou;
    }

    @Override
    public String getTitleName() {
        return "直购";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.default_place_holder;
    }

    public void initView(){
        initList();
    }

    public void initList(){

        info = new ArrayList<GoodsInfoModel.goodsInfo_YCKCTop>();


        GoodsInfoModel.goodsInfo_YCKCTop info1 = new GoodsInfoModel.goodsInfo_YCKCTop("米菲纸尿裤1",123,160,R.drawable.default_place_holder);
        info.add(info1);
        GoodsInfoModel.goodsInfo_YCKCTop info2 = new GoodsInfoModel.goodsInfo_YCKCTop("米菲纸尿裤2",12343,103,R.drawable.default_place_holder);
        info.add(info2);
        GoodsInfoModel.goodsInfo_YCKCTop info3 = new GoodsInfoModel.goodsInfo_YCKCTop("米菲纸尿裤3",4234,104,R.drawable.default_place_holder);
        info.add(info3);
        GoodsInfoModel.goodsInfo_YCKCTop info4 = new GoodsInfoModel.goodsInfo_YCKCTop("米菲纸尿裤4",435,150,R.drawable.default_place_holder);
        info.add(info4);
        GoodsInfoModel.goodsInfo_YCKCTop info5 = new GoodsInfoModel.goodsInfo_YCKCTop("米菲纸尿裤5",54665,750,R.drawable.default_place_holder);
        info.add(info5);
        GoodsInfoModel.goodsInfo_YCKCTop info6 = new GoodsInfoModel.goodsInfo_YCKCTop("米菲纸尿裤6",768,190,R.drawable.default_place_holder);
        info.add(info6);
        GoodsInfoModel.goodsInfo_YCKCTop info7 = new GoodsInfoModel.goodsInfo_YCKCTop("米菲纸尿裤7",679,1890,R.drawable.default_place_holder);
        info.add(info7);

        adapter = new GoodsAdapter(mContext);
        adapter.addData(info);
        listView.setAdapter(adapter);
    }


}
