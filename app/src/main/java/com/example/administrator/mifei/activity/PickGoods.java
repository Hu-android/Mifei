package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.GoodsAdapter;
import com.example.administrator.mifei.adapter.GoodsPickAdapter;
import com.example.administrator.mifei.bean.GoodsInfoModel;
import com.example.administrator.mifei.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class PickGoods extends BaseBackActivity {

    GoodsPickAdapter adapter;
    private List<GoodsInfoModel.goodsInfo_Pick> picks = new ArrayList<GoodsInfoModel.goodsInfo_Pick>();
    @Bind(R.id.listViewPick)
    ListView listViewPick;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pick_goods;
    }

    @Override
    public String getTitleName() {
        return "进货";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initListData();
    }

    public void initListData(){
        picks = new ArrayList<GoodsInfoModel.goodsInfo_Pick>();
        GoodsInfoModel.goodsInfo_Pick pick0 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick0);
        GoodsInfoModel.goodsInfo_Pick pick1 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick1);
        GoodsInfoModel.goodsInfo_Pick pick2 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick2);
        GoodsInfoModel.goodsInfo_Pick pick3 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick3);
        GoodsInfoModel.goodsInfo_Pick pick4 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick4);
        GoodsInfoModel.goodsInfo_Pick pick5 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick5);
        GoodsInfoModel.goodsInfo_Pick pick6 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick6);
        GoodsInfoModel.goodsInfo_Pick pick7 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick7);
        GoodsInfoModel.goodsInfo_Pick pick8 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick8);
        GoodsInfoModel.goodsInfo_Pick pick9 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick9);

        adapter = new GoodsPickAdapter(mContext);
        adapter.addData(picks);
        listViewPick.setAdapter(adapter);
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context,PickGoods.class);
        context.startActivity(intent);
    }
}
