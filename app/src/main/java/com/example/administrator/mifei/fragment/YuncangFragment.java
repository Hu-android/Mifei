package com.example.administrator.mifei.fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.mifei.R;
import com.example.administrator.mifei.activity.BuyGoods;
import com.example.administrator.mifei.activity.PickGoods;
import com.example.administrator.mifei.adapter.GoodsAdapter;
import com.example.administrator.mifei.bean.GoodsInfoModel;
import com.example.administrator.mifei.utils.AlexStatusBarUtils;
import com.example.administrator.mifei.view.BaseGoodsGroup;
import com.example.administrator.mifei.view.Yc_Top_group;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 *  云仓Fragment
 */
public class YuncangFragment extends BaseGoodsGroup{

    private List<GoodsInfoModel.goodsInfo_YCKCTop> info = new ArrayList<GoodsInfoModel.goodsInfo_YCKCTop>();
    GoodsAdapter adapter;

//    @Bind(R.id.yc_buy)
//    Yc_Top_group yc_buy;
//    @Bind(R.id.yc_pick)
//    Yc_Top_group yc_pick;
    @Bind(R.id.listViewYc)
    ListView listView;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_yuncang;
    }

    @Override
    public String getTitleName() {
        return "我的云仓";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1msg;
    }

    @Override
    public void initView() {
        initList();
//        yc_buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PickGoods.toActivity(mContext);
//            }
//        });
//
//        yc_pick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BuyGoods.toActivity(mContext);
//            }
//        });
    }

    public void initList(){
        info = new ArrayList<GoodsInfoModel.goodsInfo_YCKCTop>();

        GoodsInfoModel.goodsInfo_YCKCTop info0 = new GoodsInfoModel.goodsInfo_YCKCTop("米菲纸尿裤1",123,160,R.drawable.default_place_holder);
        info.add(info0);
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.yuncang_top_item,null);
        Yc_Top_group yc_buy = (Yc_Top_group)view.findViewById(R.id.yc_buy);
        Yc_Top_group yc_pick = (Yc_Top_group)view.findViewById(R.id.yc_pick);
        yc_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickGoods.toActivity(mContext);
            }
        });
        yc_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuyGoods.toActivity(mContext);
            }
        });
        listView.addHeaderView(view);
        adapter = new GoodsAdapter(mContext);
        adapter.addData(info);
        listView.setAdapter(adapter);
    }


}
